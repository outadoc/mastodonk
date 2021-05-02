package fr.outadoc.mastodonk.paging

import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

internal fun <T : Any> pagingSource(
    block: suspend (androidx.paging.PagingSource.LoadParams<PageInfo>) -> Page<List<T>>?
): PagingSource<PageInfo, T> {

    return object : AbstractMastodonPagingSource<T>() {
        override suspend fun loadData(params: LoadParams<PageInfo>): Page<List<T>> {
            return block(params) ?: throw NotFoundException()
        }
    }
}
