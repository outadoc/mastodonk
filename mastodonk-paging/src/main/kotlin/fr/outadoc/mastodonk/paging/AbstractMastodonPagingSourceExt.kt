package fr.outadoc.mastodonk.paging

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

internal fun <T : Any> createPagingSource(
    block: suspend (PagingSource.LoadParams<PageInfo>) -> Page<List<T>>
): PagingSource<PageInfo, T> {

    return object : AbstractMastodonPagingSource<T>() {
        override suspend fun loadData(params: LoadParams<PageInfo>): Page<List<T>> {
            return block(params)
        }
    }
}

internal fun <T : Any> createPagingSourceFromNullable(
    block: suspend (PagingSource.LoadParams<PageInfo>) -> Page<List<T>>?
): PagingSource<PageInfo, T> {

    return object : AbstractMastodonPagingSource<T>() {
        override suspend fun loadData(params: LoadParams<PageInfo>): Page<List<T>> {
            return block(params) ?: throw NotFoundException()
        }
    }
}
