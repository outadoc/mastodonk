package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.entity.streaming.StreamingEvent
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.serialization.json.Json

public class MastodonWebSocketSession(
    private val json: Json,
    delegate: WebSocketSession
) {
    public val incoming: Flow<StreamingEvent> =
        delegate.incoming
            .receiveAsFlow()
            .filterIsInstance<Frame.Text>()
            .map { frame ->
                json.decodeFromString(StreamingEvent.serializer(), frame.readText())
            }
}
