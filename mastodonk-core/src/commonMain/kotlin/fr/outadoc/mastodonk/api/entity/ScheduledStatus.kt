package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledStatus(

    @SerialName("id")
    val statusId: String,

    @SerialName("scheduled_at")
    @Serializable(with = InstantSerializer::class)
    val scheduledAt: Instant,

    @SerialName("params")
    val params: StatusParams,

    @SerialName("media_attachments")
    val mediaAttachments: List<Attachment>
)
