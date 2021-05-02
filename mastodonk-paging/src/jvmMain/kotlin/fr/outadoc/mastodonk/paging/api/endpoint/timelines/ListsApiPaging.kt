package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSource

public fun ListsApi.getListAccountsSource(listId: String): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getListAccounts(
            listId = listId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
