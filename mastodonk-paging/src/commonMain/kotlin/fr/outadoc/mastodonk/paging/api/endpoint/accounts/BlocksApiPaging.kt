package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.BlocksApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun BlocksApi.getBlocksSource(): PagingSource<PageInfo, Account>
