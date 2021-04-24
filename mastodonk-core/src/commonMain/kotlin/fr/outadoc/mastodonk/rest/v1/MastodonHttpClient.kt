package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

internal class MastodonHttpClient(
    httpClientProvider: HttpClientProvider,
    baseUrl: String
) {
    val httpClient: HttpClient = httpClientProvider.httpClient
    val baseUrl: Url = Url(baseUrl)

    suspend inline fun <reified T> get(route: String, builder: HttpRequestBuilder.() -> Unit = {}): T {
        return httpClient.get(baseUrl.copy(encodedPath = route), builder)
    }
}