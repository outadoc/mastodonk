package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.Pageable

internal class LinkHeaderPagingSource<T : Pageable>(
    private val source: suspend (params: LoadParams<PageInfo>) -> Page<List<T>>
) : PagingSource<PageInfo, T>() {

    override suspend fun load(params: LoadParams<PageInfo>): LoadResult<PageInfo, T> {
        return try {
            with(source(params)) {
                LoadResult.Page(
                    data = contents,
                    prevKey = previousPage,
                    nextKey = nextPage
                )
            }
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<PageInfo, T>): PageInfo? {

        // Timeline
        //                maxId
        //
        // |             | 20
        // |             | 19
        // |   ↑ prev    | 18
        // |             | 17
        // |   current   | 16
        // |             | 15
        // |   ↓ next    | 14
        // |             | 13
        // |             | 12
        // |             | 11
        // |             | 10
        //
        //                minId

        val pageSize = state.config.pageSize
        val anchorPosition = state.anchorPosition ?: return null

        val previousPage = state.closestPageToPosition(anchorPosition - pageSize) ?: return null
        val lastItemOfPreviousPage = previousPage.data.lastOrNull()?.id ?: return null

        return PageInfo(maxId = lastItemOfPreviousPage)
    }
}
