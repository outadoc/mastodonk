package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSourceFromNullable

public fun ListsApi.getListAccountsSource(listId: String): PagingSource<PageInfo, Account> {
    return pagingSourceFromNullable { params ->
        getListAccounts(
            listId = listId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
