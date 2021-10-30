package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.entity.paging.LegacyPageInfo
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.Pageable

internal fun <T : Pageable> pagingSource(
    block: suspend (PagingSource.LoadParams<PageInfo>) -> Page<List<T>>?
): PagingSource<PageInfo, T> {

    return object : AbstractMastodonPagingSource<T>() {
        override suspend fun loadData(params: LoadParams<PageInfo>): Page<List<T>> {
            return block(params) ?: throw NotFoundException()
        }
    }
}

internal fun <T : Pageable> legacyPagingSource(
    block: suspend (PagingSource.LoadParams<LegacyPageInfo>) -> List<T>?
): PagingSource<LegacyPageInfo, T> {

    return object : AbstractLegacyPagingSource<T>() {
        override suspend fun loadData(params: LoadParams<LegacyPageInfo>): List<T> {
            return block(params) ?: throw NotFoundException()
        }
    }
}
