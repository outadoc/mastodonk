package fr.outadoc.mastodonk.api.entity.streaming

import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.Status
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class StreamingEvent {
    public abstract val event: String
}

@Serializable
@SerialName("update")
public class UpdateEvent(
    public override val event: String,

    @SerialName("payload")
    public val payload: Status
) : StreamingEvent()

@Serializable
@SerialName("notification")
public class NotificationEvent(
    public override val event: String,

    @SerialName("payload")
    public val payload: Notification
) : StreamingEvent()

@Serializable
@SerialName("delete")
public class DeleteEvent(
    public override val event: String,

    @SerialName("payload")
    public val payload: String
) : StreamingEvent()

@Serializable
@SerialName("filters_changed")
public class FiltersChangedEvent(public override val event: String) : StreamingEvent()
