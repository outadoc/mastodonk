package fr.outadoc.mastodonk.client

import io.ktor.client.*

internal expect class HttpClientProvider() {
    fun getHttpClient(configBlock: HttpClientConfig<*>.() -> Unit): HttpClient
}