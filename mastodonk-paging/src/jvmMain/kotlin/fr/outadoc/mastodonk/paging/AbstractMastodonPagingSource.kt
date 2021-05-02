package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
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
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey ?: anchorPage?.nextKey
        }
    }
}
