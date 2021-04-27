package fr.outadoc.mastodonk.api.entity.streaming

import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.Status

/**
 * A server-sent event.
 *
 * Cast the instance to any subtype to get information about the event.
 */
public sealed class StreamingEvent

/**
 * A new status has appeared.
 */
public data class UpdateEvent(public val payload: Status) : StreamingEvent()

/**
 * A new notification has appeared.
 */
public data class NotificationEvent(public val payload: Notification) : StreamingEvent()

/**
 * The status with the given [id] has been deleted.
 */
public data class DeleteEvent(public val id: String) : StreamingEvent()

/**
 * Keyword filters have been changed.
 */
public object FiltersChangedEvent : StreamingEvent()
