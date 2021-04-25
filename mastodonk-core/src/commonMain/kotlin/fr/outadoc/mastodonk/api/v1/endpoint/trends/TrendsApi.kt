package fr.outadoc.mastodonk.api.v1.endpoint.trends

import fr.outadoc.mastodonk.client.MastodonEndpoint
import fr.outadoc.mastodonk.api.v1.entity.Tag

public interface TrendsApi : MastodonEndpoint {

    public suspend fun getTrends(limit: Int? = null): List<Tag>
}
