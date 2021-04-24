package fr.outadoc.mastodonk.rest.v1

public class MastodonHttpClient(
    httpClientProvider: HttpClientProvider,
    baseUrl: String
) {
    private val httpClient = httpClientProvider.httpClient
}