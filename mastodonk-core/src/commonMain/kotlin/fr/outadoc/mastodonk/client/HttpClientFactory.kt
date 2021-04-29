package fr.outadoc.mastodonk.client

import io.ktor.client.*

internal expect class HttpClientFactory() {
    fun create(): HttpClient
}
