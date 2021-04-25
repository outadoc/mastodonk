package fr.outadoc.mastodonk.client

import io.ktor.client.*
import io.ktor.client.engine.curl.*

internal actual class HttpClientFactory {
    actual fun create() = HttpClient(Curl)
}