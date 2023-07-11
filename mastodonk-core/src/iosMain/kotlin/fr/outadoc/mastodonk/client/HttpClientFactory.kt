package fr.outadoc.mastodonk.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

internal actual class HttpClientFactory {

    actual fun create(): HttpClient {
        return HttpClient(Darwin) {
            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
        }
    }
}
