package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*
import io.ktor.client.engine.curl.*

internal actual class HttpClientProvider {

    actual val httpClient: HttpClient
        get() = HttpClient(Curl)
}