package fr.outadoc.mastodonk.client

import io.ktor.client.HttpClient

internal expect class HttpClientFactory() {
    fun create(): HttpClient
}
