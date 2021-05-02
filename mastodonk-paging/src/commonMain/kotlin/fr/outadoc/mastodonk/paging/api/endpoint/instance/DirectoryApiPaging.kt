package fr.outadoc.mastodonk.paging.api.endpoint.instance

import fr.outadoc.mastodonk.api.endpoint.instance.DirectoryApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun DirectoryApi.getDirectorySource(): PagingSource<PageInfo, Account>
