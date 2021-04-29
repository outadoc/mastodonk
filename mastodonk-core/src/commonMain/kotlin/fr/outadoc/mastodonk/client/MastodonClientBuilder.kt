package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.auth.AuthTokenProvider
import io.ktor.http.*

public class MastodonClientBuilder {

    /**
     * The base URL for the Mastodon instance. Required.
     *
     * The API path will be appended automatically.
     */
    public var baseUrl: String? = null

    /**
     * Authentication token provider, to authenticate the requests. Optional.
     */
    public var authTokenProvider: AuthTokenProvider? = null

    public fun build(): MastodonClient {
        val baseUrl = checkNotNull(baseUrl) { "Base URL must be set on ${MastodonClientBuilder::class.simpleName}" }
        return MastodonClientImpl(
            httpClient = MastodonHttpClient(
                httpClientFactory = HttpClientFactory(),
                authTokenProvider = authTokenProvider,
                baseUrl = Url(baseUrl)
            )
        )
    }
}
