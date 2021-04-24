package fr.outadoc.mastodonk.serializer

import io.ktor.client.features.json.serializer.*

public object JsonSerializerProvider {
    public val serializer: KotlinxSerializer = KotlinxSerializer()
}
