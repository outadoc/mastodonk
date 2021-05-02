package fr.outadoc.mastodonk.paging.api.endpoint.search

import fr.outadoc.mastodonk.api.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun SearchApi.searchAccountsSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null,
): PagingSource<PageInfo, Account>

public expect fun SearchApi.searchStatusesSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null,
): PagingSource<PageInfo, Status>

public expect fun SearchApi.searchHashtagsSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null,
): PagingSource<PageInfo, Tag>
