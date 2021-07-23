package fr.outadoc.mastodonk.paging

import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.Pageable

internal fun <T : Pageable> pagingSource(
    block: suspend (androidx.paging.PagingSource.LoadParams<PageInfo>) -> Page<List<T>>?
): PagingSource<PageInfo, T> {

    return object : AbstractMastodonPagingSource<T>() {
        override suspend fun loadData(params: LoadParams<PageInfo>): Page<List<T>> {
            return block(params) ?: throw NotFoundException()
        }
    }
}
