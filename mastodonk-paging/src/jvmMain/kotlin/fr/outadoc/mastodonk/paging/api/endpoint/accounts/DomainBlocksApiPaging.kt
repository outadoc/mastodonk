package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.accounts.DomainBlocksApi
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSource

public fun DomainBlocksApi.getDomainBlocksSource(): PagingSource<PageInfo, String> {
    return pagingSource { params ->
        getDomainBlocks(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
