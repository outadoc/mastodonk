package fr.outadoc.mastodonk.paging.api.endpoint.search

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo
import fr.outadoc.mastodonk.paging.offsetPagingSource

public fun SearchApi.searchAccountsSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null
): PagingSource<OffsetPageInfo, Account> {
    return offsetPagingSource { params ->
        search(
            q = q,
            accountId = accountId,
            type = SearchType.Accounts,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        ).accounts
    }
}

public fun SearchApi.searchStatusesSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null
): PagingSource<OffsetPageInfo, Status> {
    return offsetPagingSource { params ->
        search(
            q = q,
            accountId = accountId,
            type = SearchType.Statuses,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        ).statuses
    }
}

public fun SearchApi.searchHashtagsSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null
): PagingSource<OffsetPageInfo, Tag> {
    return offsetPagingSource { params ->
        search(
            q = q,
            accountId = accountId,
            type = SearchType.Hashtags,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        ).hashtags
    }
}
