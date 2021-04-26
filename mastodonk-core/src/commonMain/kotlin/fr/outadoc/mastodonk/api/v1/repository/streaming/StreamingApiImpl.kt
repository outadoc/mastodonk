package fr.outadoc.mastodonk.api.v1.repository.streaming

import fr.outadoc.mastodonk.api.v1.endpoint.streaming.StreamingApi
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*

internal class StreamingApiImpl(private val client: MastodonHttpClient) : StreamingApi {

    private suspend fun getStream(
        stream: String,
        session: suspend ClientWebSocketSession.() -> Unit,
        builder: HttpRequestBuilder.() -> Unit = {}
    ) {
        client.getStream("/api/v1/streaming", session) {
            parameter("stream", stream)
            builder()
        }
    }

    override suspend fun getUserStream(session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("user", session)
    }

    override suspend fun getPublicStream(session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("public", session)
    }

    override suspend fun getPublicLocalStream(session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("public:local", session)
    }

    override suspend fun getHashtagStream(tag: String, session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("hashtag", session) {
            parameter("tag", tag)
        }
    }

    override suspend fun getHashtagLocalStream(tag: String, session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("hashtag:local", session) {
            parameter("tag", tag)
        }
    }

    override suspend fun getListStream(list: String, session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("list", session) {
            parameter("list", list)
        }
    }

    override suspend fun getDirectStream(session: suspend ClientWebSocketSession.() -> Unit) {
        getStream("direct", session)
    }
}
