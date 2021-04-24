package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*

internal expect class HttpClientProvider() {
    val httpClient: HttpClient
}