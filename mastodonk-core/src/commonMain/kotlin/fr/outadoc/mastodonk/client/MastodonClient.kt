package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.timelines.TimelinesApi

public interface MastodonClient {
    public val timelines: TimelinesApi
}
