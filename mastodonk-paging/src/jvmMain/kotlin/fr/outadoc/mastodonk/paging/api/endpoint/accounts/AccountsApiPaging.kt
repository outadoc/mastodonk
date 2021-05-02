package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSource

public fun AccountsApi.getFollowersSource(accountId: String): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getFollowers(
            accountId = accountId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public fun AccountsApi.getFollowingSource(accountId: String): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getFollowing(
            accountId = accountId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
