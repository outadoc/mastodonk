package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.TimelinesApi

public interface MastodonClient {

    public val timelines: TimelinesApi

    public class Builder {

        private var baseUrl: String? = null

        public fun baseUrl(baseUrl: String): Builder = apply {
            this.baseUrl = baseUrl
        }

        public fun build(): MastodonClient {
            val baseUrl = checkNotNull(baseUrl) { "Base URL must be set on MastodonClient.Builder" }
            return MastodonClientImpl(
                httpClient = MastodonHttpClient(
                    httpClientProvider = HttpClientProvider(),
                    baseUrl = baseUrl
                )
            )
        }
    }
}
