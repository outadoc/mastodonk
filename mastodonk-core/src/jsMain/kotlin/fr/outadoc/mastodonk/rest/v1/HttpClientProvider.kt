package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*
import io.ktor.client.engine.js.*

internal actual class HttpClientProvider {

    actual fun getHttpClient(configBlock: HttpClientConfig<*>.() -> Unit): HttpClient {
        return HttpClient(Js) {
            configBlock()
        }
    }
}