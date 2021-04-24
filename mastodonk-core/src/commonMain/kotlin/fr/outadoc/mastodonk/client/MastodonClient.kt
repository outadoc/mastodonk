package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.TimelinesApi
import fr.outadoc.mastodonk.rest.v1.HttpClientProvider

public interface MastodonClient {

    public val timelines: TimelinesApi

    public class Builder {

        public fun build(): MastodonClient {
            return MastodonClientImpl(
                clientProvider = HttpClientProvider()
            )
        }
    }
}
