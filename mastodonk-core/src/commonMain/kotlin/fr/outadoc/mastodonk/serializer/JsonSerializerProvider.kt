package fr.outadoc.mastodonk.serializer

import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

public object JsonSerializerProvider {

    public val serializer: KotlinxSerializer =
        KotlinxSerializer(
            Json {
                ignoreUnknownKeys = true
            }
        )
}
