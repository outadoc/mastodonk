package fr.outadoc.mastodonk.rest

import fr.outadoc.mastodonk.api.v1.entity.Error
import fr.outadoc.mastodonk.client.MastodonApiException
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

internal fun HttpClientConfig<*>.installMastodonSerializer() {
    install(JsonFeature) {
        KotlinxSerializer(
            kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
        )
    }
}

internal fun HttpClientConfig<*>.installMastodonResponseValidator() {
    HttpResponseValidator {
        validateResponse { response ->
            val statusCode = response.status.value
            if (statusCode in 400..599) {
                val apiError = try {
                    response.content.readUTF8Line(2048)
                        ?.let { errorJson ->
                            Json.Default.decodeFromString(
                                Error.serializer(),
                                errorJson
                            )
                        }
                } catch (e: Exception) {
                    null
                }

                throw MastodonApiException(statusCode, apiError)
            }
        }
    }
}