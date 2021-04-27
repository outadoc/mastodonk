package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Status

/**
 * View bookmarked statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/bookmarks/)
 */
public interface BookmarksApi {

    /**
     * Gets the bookmarked statuses for this account.
     */
    public suspend fun getBookmarks(
        maxId: String?,
        sinceId: String?,
        limit: Int?,
        minId: String?
    ): List<Status>
}
