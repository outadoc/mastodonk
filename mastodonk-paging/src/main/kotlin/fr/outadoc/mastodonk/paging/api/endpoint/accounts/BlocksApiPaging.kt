package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.accounts.BlocksApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSource

public fun BlocksApi.getBlocksSource(): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getBlocks(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
