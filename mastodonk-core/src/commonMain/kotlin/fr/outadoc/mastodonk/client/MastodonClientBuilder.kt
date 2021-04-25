package fr.outadoc.mastodonk.client

public class MastodonClientBuilder {

    public var baseUrl: String? = null

    public fun setBaseUrl(baseUrl: String): MastodonClientBuilder = apply {
        this.baseUrl = baseUrl
    }

    public fun build(): MastodonClient {
        val baseUrl = checkNotNull(baseUrl) { "Base URL must be set on MastodonClient.Builder" }
        return MastodonClientImpl(
            httpClient = MastodonHttpClient(
                httpClientFactory = HttpClientFactory(),
                baseUrl = baseUrl
            )
        )
    }
}
