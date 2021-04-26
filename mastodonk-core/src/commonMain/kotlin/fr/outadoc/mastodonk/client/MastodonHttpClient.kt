package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.entity.Error
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

internal class MastodonHttpClient(
    httpClientFactory: HttpClientFactory,
    private val authTokenProvider: AuthTokenProvider?,
    baseUrl: String
) {
    val baseUrl: Url = Url(baseUrl)

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val httpClient: HttpClient = httpClientFactory.create()
        .config {
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer(json = json)
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
        return httpClient.get(baseUrl.copy(encodedPath = route)) {
            // Inject auth token if available
            authTokenProvider?.provideAuthToken()?.let { token ->
                header(HttpHeaders.Authorization, token.toString())
            }
            builder()
        }
    }

    suspend fun getStream(
        route: String,
        webSocketSession: suspend ClientWebSocketSession.() -> Unit,
        builder: HttpRequestBuilder.() -> Unit
    ) {
        httpClient.ws(
            urlString = baseUrl.copy(protocol = URLProtocol.WSS, encodedPath = route).toString(),
            request = {
                authTokenProvider?.provideAuthToken()?.let { token ->
                    parameter("access_token", token.toString())
                }
                builder()
            },
            block = webSocketSession
        )
    }
}
