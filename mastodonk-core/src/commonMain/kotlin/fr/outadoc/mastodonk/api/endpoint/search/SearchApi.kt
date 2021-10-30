package fr.outadoc.mastodonk.api.endpoint.search

import fr.outadoc.mastodonk.api.entity.Results
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.paging.LegacyPageInfo

/**
 * Search for content in accounts, statuses and hashtags.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/search/)
 */
public interface SearchApi {

    /**
     * Searches for content in accounts, statuses and hashtags.
     *
     * @param q Search query.
     * @param accountId If provided, statuses returned will be authored only by this account.
     * @param type If provided, will only search for this type of content.
     * @param excludeUnreviewed Filter out unreviewed tags? Use true when trying to find trending tags.
     * @param attemptResolve Attempt WebFinger lookup?
     * @param onlyFollowing Only include accounts that the user is following?
     */
    public suspend fun search(
        q: String,
        accountId: String? = null,
        type: SearchType? = null,
        excludeUnreviewed: Boolean? = null,
        attemptResolve: Boolean? = null,
        onlyFollowing: Boolean? = null,
        limit: Int? = null,
        pageInfo: LegacyPageInfo? = null
    ): Results
}
