package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.auth.AuthTokenProvider

public class MastodonClientBuilder {

    /**
     * The hostname of the Mastodon instance. Required.
     */
    public var domain: String? = null

    /**
     * Authentication token provider, to authenticate the requests. Optional.
     */
    public var authTokenProvider: AuthTokenProvider? = null

    public fun build(): MastodonClient {
        val domain = checkNotNull(domain) { "Base URL must be set on ${MastodonClientBuilder::class.simpleName}" }
        return MastodonClientImpl(
            httpClient = MastodonHttpClient(
                httpClientFactory = HttpClientFactory(),
                authTokenProvider = authTokenProvider,
                domain = domain
            )
        )
    }
}
