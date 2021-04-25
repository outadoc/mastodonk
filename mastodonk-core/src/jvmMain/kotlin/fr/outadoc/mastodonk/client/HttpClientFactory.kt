package fr.outadoc.mastodonk.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*

internal actual class HttpClientFactory {

    actual fun create() = HttpClient(CIO) {
        engine {
            endpoint {
                keepAliveTime = 5_000
                connectTimeout = 5_000
                requestTimeout = 30_000
                connectAttempts = 5
            }
        }
    }
}
