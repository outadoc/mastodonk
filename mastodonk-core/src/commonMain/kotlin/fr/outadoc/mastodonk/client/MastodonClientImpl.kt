package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.rest.v1.endpoint.TimelinesApiImpl

internal class MastodonClientImpl(httpClient: MastodonHttpClient) : MastodonClient {
    override val timelines = TimelinesApiImpl(httpClient)
}
