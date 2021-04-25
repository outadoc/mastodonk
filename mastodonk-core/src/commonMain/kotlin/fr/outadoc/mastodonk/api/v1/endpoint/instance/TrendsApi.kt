package fr.outadoc.mastodonk.api.v1.endpoint.instance

import fr.outadoc.mastodonk.api.v1.entity.Tag

public interface TrendsApi {

    public suspend fun getTrends(limit: Int? = null): List<Tag>
}
