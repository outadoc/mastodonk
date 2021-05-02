package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun AccountsApi.getFollowersSource(accountId: String): PagingSource<PageInfo, Account>

public expect fun AccountsApi.getFollowingSource(accountId: String): PagingSource<PageInfo, Account>
