package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.entity.Error
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

internal class MastodonHttpClient(
    httpClientProvider: HttpClientProvider,
    baseUrl: String
) {
    val baseUrl: Url = Url(baseUrl)

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val httpClient: HttpClient = httpClientProvider.getHttpClient {
        install(JsonFeature) {
            KotlinxSerializer(json = json)
        }

        HttpResponseValidator {
            validateResponse { response ->
                val statusCode = response.status.value
                if (statusCode in 400..599) {
                    val apiError = response.decodeErrorBodyOrNull()
                    throw MastodonApiException(statusCode, apiError)
                }
            }
        }
    }

    private suspend fun HttpResponse.decodeErrorBodyOrNull(): Error? {
        return try {
            content.readUTF8Line(2048)
                ?.let { errorJson ->
                    json.decodeFromString(
                        Error.serializer(),
                        errorJson
                    )
                }
        } catch (e: Exception) {
            null
        }
    }

    suspend inline fun <reified T> request(route: String, builder: HttpRequestBuilder.() -> Unit = {}): T {
        return httpClient.get(baseUrl.copy(encodedPath = route), builder)
    }
}