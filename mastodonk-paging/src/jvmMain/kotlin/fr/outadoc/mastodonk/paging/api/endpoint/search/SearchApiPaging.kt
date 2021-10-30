package fr.outadoc.mastodonk.paging.api.endpoint.search

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.paging.LegacyPageInfo
import fr.outadoc.mastodonk.paging.legacyPagingSource

public fun SearchApi.searchAccountsSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null
): PagingSource<LegacyPageInfo, Account> {
    return legacyPagingSource { params ->
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
): PagingSource<LegacyPageInfo, Status> {
    return legacyPagingSource { params ->
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
): PagingSource<LegacyPageInfo, Tag> {
    return legacyPagingSource { params ->
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
