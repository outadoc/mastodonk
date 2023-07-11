package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.entity.Error
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.parseLinkHeaderToPageRefs
import fr.outadoc.mastodonk.api.entity.streaming.RawStreamingEvent
import fr.outadoc.mastodonk.api.entity.streaming.StreamingEvent
import fr.outadoc.mastodonk.api.entity.streaming.StreamingEventFactory
import fr.outadoc.mastodonk.api.repository.instance.InstanceApiImpl
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.ws
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.serialization.json.Json

internal class MastodonHttpClient(
    httpClientFactory: HttpClientFactory,
    private val authTokenProvider: AuthTokenProvider?,
    domain: String,
    enableLogging: Boolean
) {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
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
            install(ContentNegotiation) {
                json(json)
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
            bodyAsText().let { errorJson ->
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
        val res = httpClient.request {
            url(
                URLBuilder(baseUrl)
                    .apply { encodedPath = route }
                    .build()
            )
            addAuthToken()
            builder()
        }

        val linkHeaders = res.headers["Link"]?.parseLinkHeaderToPageRefs()
        return Page(
            contents = json.decodeFromString(res.bodyAsText()),
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
        return httpClient.request(
            URLBuilder(baseUrl)
                .apply { encodedPath = route }
                .build()
        ) {
            addAuthToken()
            builder()
        }.body()
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
                url(
                    URLBuilder(streamingBaseUrl)
                        .apply { encodedPath = route }
                        .build()
                )
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
