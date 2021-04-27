package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Tag

/**
 * View hashtags that are currently being used more frequently than usual.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/trends/)
 */
public interface TrendsApi {

    /**
     * Tags that are being used more frequently within the past week.
     */
    public suspend fun getTrends(limit: Int? = null): List<Tag>
}
