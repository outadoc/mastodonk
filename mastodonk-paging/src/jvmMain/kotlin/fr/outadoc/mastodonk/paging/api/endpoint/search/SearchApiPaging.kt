package fr.outadoc.mastodonk.paging.api.endpoint.search

import fr.outadoc.mastodonk.api.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import androidx.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public fun SearchApi.searchAccountsSource(
    q: String,
    accountId: String?,
    excludeUnreviewed: Boolean?,
    attemptResolve: Boolean?,
    onlyFollowing: Boolean?,
): PagingSource<PageInfo, Account> {
    return pagingSource { params ->
        val page = search(
            q = q,
            accountId = accountId,
            type = SearchType.Accounts,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        )

        Page(
            contents = page.contents.accounts,
            nextPage = page.nextPage,
            previousPage = page.previousPage
        )
    }
}

public fun SearchApi.searchStatusesSource(
    q: String,
    accountId: String?,
    excludeUnreviewed: Boolean?,
    attemptResolve: Boolean?,
    onlyFollowing: Boolean?,
): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        val page = search(
            q = q,
            accountId = accountId,
            type = SearchType.Statuses,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        )

        Page(
            contents = page.contents.statuses,
            nextPage = page.nextPage,
            previousPage = page.previousPage
        )
    }
}

public fun SearchApi.searchHashtagsSource(
    q: String,
    accountId: String?,
    excludeUnreviewed: Boolean?,
    attemptResolve: Boolean?,
    onlyFollowing: Boolean?,
): PagingSource<PageInfo, Tag> {
    return pagingSource { params ->
        val page = search(
            q = q,
            accountId = accountId,
            type = SearchType.Hashtags,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        )

        Page(
            contents = page.contents.hashtags,
            nextPage = page.nextPage,
            previousPage = page.previousPage
        )
    }
}
