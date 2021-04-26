package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Tag

public interface TrendsApi {

    public suspend fun getTrends(limit: Int? = null): List<Tag>
}
