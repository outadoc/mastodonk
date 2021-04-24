package fr.outadoc.mastodonk.rest.v1

import fr.outadoc.mastodonk.serializer.JsonSerializerProvider
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*

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

            install(JsonFeature) {
                serializer = JsonSerializerProvider.serializer
            }
        }
}
