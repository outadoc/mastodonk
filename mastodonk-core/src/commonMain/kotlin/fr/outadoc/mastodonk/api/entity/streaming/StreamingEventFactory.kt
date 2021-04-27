package fr.outadoc.mastodonk.api.entity.streaming

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal class StreamingEventFactory(private val json: Json) {

    fun from(rawEvent: RawStreamingEvent): StreamingEvent? {
        if (rawEvent.payload == null) return null
        return when (rawEvent.event) {
            "update" -> UpdateEvent(
                payload = json.decodeFromString(rawEvent.payload)
            )
            "notification" -> NotificationEvent(
                payload = json.decodeFromString(rawEvent.payload)
            )
            "delete" -> DeleteEvent(
                statusId = rawEvent.payload
            )
            "filters_changed" -> FiltersChangedEvent
            else -> null
        }
    }
}
