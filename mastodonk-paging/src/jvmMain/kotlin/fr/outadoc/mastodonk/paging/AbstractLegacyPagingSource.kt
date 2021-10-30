package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import fr.outadoc.mastodonk.api.entity.paging.LegacyPageInfo

internal abstract class AbstractLegacyPagingSource<T : Any> : PagingSource<LegacyPageInfo, T>() {

    override val jumpingSupported: Boolean = true

    abstract suspend fun loadData(params: LoadParams<LegacyPageInfo>): List<T>

    override suspend fun load(params: LoadParams<LegacyPageInfo>): LoadResult<LegacyPageInfo, T> {
        return try {
            val contents = loadData(params)
            val offset = params.key?.offset ?: 0

            LoadResult.Page(
                data = contents,
                prevKey = if (offset == 0) null
                else LegacyPageInfo(
                    offset = maxOf(0, offset - params.loadSize)
                ),
                nextKey = if (contents.size < params.loadSize) null
                else LegacyPageInfo(
                    offset = offset + contents.size
                )
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<LegacyPageInfo, T>): LegacyPageInfo? {
        return LegacyPageInfo(offset = state.anchorPosition)
    }
}
