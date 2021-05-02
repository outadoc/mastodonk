package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.accounts.BookmarksApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSource

public fun BookmarksApi.getBookmarksSource(): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getBookmarks(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
