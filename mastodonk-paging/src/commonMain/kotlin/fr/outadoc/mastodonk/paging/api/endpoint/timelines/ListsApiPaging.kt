package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun ListsApi.getListAccountsSource(listId: String): PagingSource<PageInfo, Account>
