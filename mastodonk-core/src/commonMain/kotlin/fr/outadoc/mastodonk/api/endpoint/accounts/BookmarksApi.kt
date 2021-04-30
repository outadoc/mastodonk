package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View bookmarked statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/bookmarks/)
 */
public interface BookmarksApi {

    /**
     * Gets the bookmarked statuses for this account.
     */
    public suspend fun getBookmarks(limit: Int? = null, pageInfo: PageInfo? = null): Page<List<Status>>
}
