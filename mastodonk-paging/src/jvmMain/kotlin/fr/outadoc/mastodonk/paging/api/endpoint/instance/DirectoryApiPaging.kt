package fr.outadoc.mastodonk.paging.api.endpoint.instance

import fr.outadoc.mastodonk.api.endpoint.instance.DirectoryApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun DirectoryApi.getDirectorySource(): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        getDirectory(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
