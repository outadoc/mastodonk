package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*
import io.ktor.client.engine.cio.*

internal actual class HttpClientProvider {

    actual val httpClient: HttpClient
        get() = HttpClient(CIO) {
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