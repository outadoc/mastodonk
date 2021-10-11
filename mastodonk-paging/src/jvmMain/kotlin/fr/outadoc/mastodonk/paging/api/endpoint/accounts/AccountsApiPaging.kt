package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun AccountsApi.getFollowersSource(accountId: String): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getFollowers(
            accountId = accountId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public actual fun AccountsApi.getFollowingSource(accountId: String): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getFollowing(
            accountId = accountId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public actual fun AccountsApi.getStatusesSource(accountId: String): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getStatuses(
            accountId = accountId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
