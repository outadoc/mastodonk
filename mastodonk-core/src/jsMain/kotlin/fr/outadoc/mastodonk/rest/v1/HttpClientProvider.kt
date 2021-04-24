package fr.outadoc.mastodonk.rest.v1

import fr.outadoc.mastodonk.serializer.JsonSerializerProvider
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.json.*

public actual class HttpClientProvider {

    public actual val httpClient: HttpClient
        get() = HttpClient(Js) {
            install(JsonFeature) {
                serializer = JsonSerializerProvider.serializer
            }
        }
}