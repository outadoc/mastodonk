package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.FeaturedTag
import fr.outadoc.mastodonk.api.entity.Tag

/**
 * View and managed featured hashtags.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/featured_tags/)
 */
public interface FeaturedTagsApi {

    /**
     * Gets the current account's featured tags.
     */
    public suspend fun getFeaturedTags(): List<FeaturedTag>

    /**
     * Gets the list of suggested tags to be featured for this account.
     *
     * Shows the account's 10 most-used tags, with usage history, for the past week.
     */
    public suspend fun suggestedTags(): List<Tag>

    /**
     * Feature a hashtag.
     */
    public suspend fun featureTag(name: String): FeaturedTag

    /**
     * Unfeature a hashtag.
     */
    public suspend fun unfeatureTag(id: String)
}
