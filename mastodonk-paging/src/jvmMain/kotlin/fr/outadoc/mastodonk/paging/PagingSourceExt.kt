package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.Pageable

internal fun <T : Pageable> pagingSource(
    block: suspend (PagingSource.LoadParams<PageInfo>) -> Page<List<T>>?
): PagingSource<PageInfo, T> {
    return LinkHeaderPagingSource { params -> block(params) ?: throw NotFoundException() }
}

internal fun <T : Pageable> offsetPagingSource(
    block: suspend (PagingSource.LoadParams<OffsetPageInfo>) -> List<T>
): PagingSource<OffsetPageInfo, T> {
    return OffsetPagingSource { params -> block(params) }
}
