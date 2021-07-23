package fr.outadoc.mastodonk.paging

import androidx.paging.PagingState
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

internal abstract class AbstractMastodonPagingSource<T : Any> : PagingSource<PageInfo, T>() {

    abstract suspend fun loadData(params: LoadParams<PageInfo>): Page<List<T>>

    override suspend fun load(params: LoadParams<PageInfo>): LoadResult<PageInfo, T> {
        return try {
            with(loadData(params)) {
                LoadResult.Page(
                    data = contents,
                    prevKey = previousPage,
                    nextKey = nextPage
                )
            }
        } catch (e: Exception) {
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

        val anchorPosition = state.anchorPosition ?: return null
        val currentPage = state.closestPageToPosition(anchorPosition) ?: return null

        val firstIdOfPrevPage = currentPage.prevKey?.minId
        val firstIdOfNextPage = currentPage.nextKey?.maxId

        // We want to load items for the current page (so, contained between prevKey and nextKey).

        return when {
            // Load items with id GREATER THAN the first item of the previous page
            firstIdOfPrevPage != null -> PageInfo(maxId = firstIdOfPrevPage)

            // If there's no previous page, load items with id LESS THAN the id of
            // the first item of the next page.
            firstIdOfNextPage != null -> PageInfo(minId = firstIdOfNextPage)

            // There's only one page, just load the default
            else -> null
        }
    }
}
