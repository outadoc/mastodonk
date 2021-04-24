package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*

internal expect class HttpClientProvider() {
    fun getHttpClient(configBlock: HttpClientConfig<*>.() -> Unit): HttpClient
}