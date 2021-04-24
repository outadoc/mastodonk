package fr.outadoc.mastodonk.client

import io.ktor.client.*
import io.ktor.client.engine.curl.*

internal actual class HttpClientProvider {

    actual fun getHttpClient(configBlock: HttpClientConfig<*>.() -> Unit): HttpClient {
        return HttpClient(Curl) {
            configBlock()
        }
    }
}