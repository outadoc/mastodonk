package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.entity.Error
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.parseLinkHeaderToPageRefs
import fr.outadoc.mastodonk.api.entity.streaming.RawStreamingEvent
import fr.outadoc.mastodonk.api.entity.streaming.StreamingEvent
import fr.outadoc.mastodonk.api.entity.streaming.StreamingEventFactory
import fr.outadoc.mastodonk.api.repository.instance.InstanceApiImpl
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import io.ktor.utils.io.charsets.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal class MastodonHttpClient(
    httpClientFactory: HttpClientFactory,
    private val authTokenProvider: AuthTokenProvider?,
    domain: String,
    enableLogging: Boolean
) {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    private val streamingEventFactory = StreamingEventFactory(json)
    private val baseUrl = URLBuilder(URLProtocol.HTTPS, domain).build()

    private val streamingBaseUrlCache: Url? = null
    private suspend fun getStreamingBaseUrl(): Url {
        return streamingBaseUrlCache
            ?: InstanceApiImpl(this)
                .getInstanceInfo()
                .urls.streamingApiUrl
                .let { Url(it) }
    }

    private val httpClient: HttpClient = httpClientFactory.create()
        .config {
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer(json = json)
            }

            install(Logging) {
                level = if (enableLogging) LogLevel.HEADERS else LogLevel.NONE
            }

            HttpResponseValidator {
                handleResponseException { e ->
                    if (e is ClientRequestException) {
                        val statusCode = e.response.status.value
                        if (statusCode in 400..599) {
                            val apiError = e.response.decodeErrorBodyOrNull()
                            throw MastodonApiException(statusCode, apiError)
                        }
                    }
                }
            }
        }

    private suspend fun HttpResponse.decodeErrorBodyOrNull(): Error? {
        return try {
            readText(Charsets.UTF_8).let { errorJson ->
                json.decodeFromString(
                    Error.serializer(),
                    errorJson
                )
            }
        } catch (e: Exception) {
            null
        }
    }

    fun HttpRequestBuilder.addAuthToken() {
        // Inject auth token if available
        authTokenProvider?.provideAuthToken()?.let { token ->
            header(HttpHeaders.Authorization, token.toString())
        }
    }

    suspend inline fun <reified T> requestPage(
        route: String,
        builder: HttpRequestBuilder.() -> Unit = {}
    ): Page<T> {
        val res = httpClient.request<HttpResponse> {
            url(baseUrl.copy(encodedPath = route))
            addAuthToken()
            builder()
        }

        val linkHeaders = res.headers["Link"]?.parseLinkHeaderToPageRefs()
        return Page(
            contents = json.decodeFromString(res.readText()),
            nextPage = linkHeaders?.get("next"),
            previousPage = linkHeaders?.get("prev")
        )
    }

    suspend inline fun <reified T> requestPageOrNull(
        route: String,
        builder: HttpRequestBuilder.() -> Unit = {}
    ): Page<T>? {
        return try {
            requestPage(route, builder)
        } catch (e: MastodonApiException) {
            when (e.errorCode) {
                HttpStatusCode.NotFound.value -> null
                else -> throw e
            }
        }
    }

    suspend inline fun <reified T> request(
        route: String,
        builder: HttpRequestBuilder.() -> Unit = {}
    ): T {
        return httpClient.request(baseUrl.copy(encodedPath = route)) {
            addAuthToken()
            builder()
        }
    }

    suspend inline fun <reified T> requestOrNull(
        route: String,
        builder: HttpRequestBuilder.() -> Unit = {}
    ): T? {
        return try {
            request(route, builder)
        } catch (e: MastodonApiException) {
            when (e.errorCode) {
                HttpStatusCode.NotFound.value -> null
                else -> throw e
            }
        }
    }

    suspend fun getStream(
        route: String,
        builder: HttpRequestBuilder.() -> Unit
    ): Flow<StreamingEvent> = flow {
        val streamingBaseUrl = getStreamingBaseUrl()
        httpClient.ws(
            request = {
                url(streamingBaseUrl.copy(encodedPath = route))
                authTokenProvider?.provideAuthToken()?.let { token ->
                    parameter("access_token", token.toString())
                }
                builder()
            },
            block = {
                incoming.receiveAsFlow()
                    .filterIsInstance<Frame.Text>()
                    .map { frame -> json.decodeFromString<RawStreamingEvent>(frame.readText()) }
                    .mapNotNull { rawEvent -> streamingEventFactory.from(rawEvent) }
                    .let { flow -> emitAll(flow) }
            })
    }
}
