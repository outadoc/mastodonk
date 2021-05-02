package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.MutesApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun MutesApi.getMutesSource(): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getMutes(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
