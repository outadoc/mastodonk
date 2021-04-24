package fr.outadoc.mastodonk.api.v1.endpoint

import fr.outadoc.mastodonk.client.MastodonEndpoint
import fr.outadoc.mastodonk.api.v1.entity.Tag

public interface TrendsApi : MastodonEndpoint {

    public suspend fun getTrends(limit: Int?): List<Tag>
}