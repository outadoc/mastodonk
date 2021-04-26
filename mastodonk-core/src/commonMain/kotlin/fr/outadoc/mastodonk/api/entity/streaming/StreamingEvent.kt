package fr.outadoc.mastodonk.api.entity.streaming

import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.Status

public sealed class StreamingEvent

public data class UpdateEvent(public val payload: Status) : StreamingEvent()

public data class NotificationEvent(public val payload: Notification) : StreamingEvent()

public data class DeleteEvent(public val id: String) : StreamingEvent()

public object FiltersChangedEvent : StreamingEvent()
