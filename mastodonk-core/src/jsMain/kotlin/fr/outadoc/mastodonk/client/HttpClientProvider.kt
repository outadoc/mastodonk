package fr.outadoc.mastodonk.client

import io.ktor.client.*
import io.ktor.client.engine.js.*

internal actual class HttpClientProvider {

    actual fun getHttpClient(configBlock: HttpClientConfig<*>.() -> Unit): HttpClient {
        return HttpClient(Js) {
            configBlock()
        }
    }
}