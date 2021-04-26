package fr.outadoc.mastodonk.api.v1.endpoint.streaming

import io.ktor.client.features.websocket.*

public interface StreamingApi {

    public suspend fun getUserStream(session: suspend ClientWebSocketSession.() -> Unit)

    public suspend fun getPublicStream(session: suspend ClientWebSocketSession.() -> Unit)

    public suspend fun getPublicLocalStream(session: suspend ClientWebSocketSession.() -> Unit)

    public suspend fun getHashtagStream(tag: String, session: suspend ClientWebSocketSession.() -> Unit)

    public suspend fun getHashtagLocalStream(tag: String, session: suspend ClientWebSocketSession.() -> Unit)

    public suspend fun getListStream(list: String, session: suspend ClientWebSocketSession.() -> Unit)

    public suspend fun getDirectStream(session: suspend ClientWebSocketSession.() -> Unit)
}
