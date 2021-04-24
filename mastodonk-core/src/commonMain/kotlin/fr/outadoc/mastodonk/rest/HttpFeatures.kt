package fr.outadoc.mastodonk.rest

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

public fun HttpClientConfig<*>.installMastodonSerializer() {
    install(JsonFeature) {
        KotlinxSerializer(
            kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
        )
    }
}
