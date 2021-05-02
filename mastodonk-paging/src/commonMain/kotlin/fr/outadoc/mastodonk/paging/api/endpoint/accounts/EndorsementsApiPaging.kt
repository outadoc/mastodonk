package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.EndorsementsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun EndorsementsApi.getFeaturedAccountsSource(): PagingSource<PageInfo, Account>
