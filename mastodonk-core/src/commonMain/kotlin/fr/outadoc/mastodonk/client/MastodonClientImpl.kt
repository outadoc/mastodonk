package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.rest.v1.HttpClientProvider
import fr.outadoc.mastodonk.rest.v1.endpoint.TimelinesApiImpl

internal class MastodonClientImpl(clientProvider: HttpClientProvider) : MastodonClient {

    private val client = clientProvider.httpClient

    override val timelines = TimelinesApiImpl(client)
}