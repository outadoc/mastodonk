package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.EndorsementsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import androidx.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public fun EndorsementsApi.getFeaturedAccountsSource(): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getFeaturedAccounts(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
