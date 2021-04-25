package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.repository.timelines.TimelinesApiImpl

internal class MastodonClientImpl(httpClient: MastodonHttpClient) : MastodonClient {
    override val timelines = TimelinesApiImpl(httpClient)
}
