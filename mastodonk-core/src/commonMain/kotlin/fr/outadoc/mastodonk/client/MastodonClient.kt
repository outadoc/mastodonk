package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.TimelinesApi

public interface MastodonClient {
    public val timelines: TimelinesApi
}
