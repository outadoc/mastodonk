package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.auth.AuthTokenProvider

public class MastodonClientBuilder {

    public var baseUrl: String? = null
    public var authTokenProvider: AuthTokenProvider? = null

    public fun setBaseUrl(baseUrl: String): MastodonClientBuilder = apply {
        this.baseUrl = baseUrl
    }

    public fun setAuthTokenProvider(authTokenProvider: AuthTokenProvider): MastodonClientBuilder = apply {
        this.authTokenProvider = authTokenProvider
    }

    public fun build(): MastodonClient {
        val baseUrl = checkNotNull(baseUrl) { "Base URL must be set on MastodonClient.Builder" }
        return MastodonClientImpl(
            httpClient = MastodonHttpClient(
                httpClientFactory = HttpClientFactory(),
                authTokenProvider = authTokenProvider,
                baseUrl = baseUrl
            )
        )
    }
}
