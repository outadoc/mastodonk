package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo

internal class OffsetPagingSource<T : Any>(
    private val source: suspend (params: LoadParams<OffsetPageInfo>) -> List<T>
) : PagingSource<OffsetPageInfo, T>() {

    override val jumpingSupported: Boolean = true

    override suspend fun load(params: LoadParams<OffsetPageInfo>): LoadResult<OffsetPageInfo, T> {
        return try {
            val contents = source(params)
            val offset = params.key?.offset ?: 0

            LoadResult.Page(
                data = contents,
                prevKey = if (offset == 0) null
                else OffsetPageInfo(
                    offset = maxOf(0, offset - params.loadSize)
                ),
                nextKey = if (contents.size + 1 < params.loadSize) null
                else OffsetPageInfo(
                    offset = offset + contents.size + 1
                )
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<OffsetPageInfo, T>): OffsetPageInfo? {
        return OffsetPageInfo(offset = state.anchorPosition)
    }
}
