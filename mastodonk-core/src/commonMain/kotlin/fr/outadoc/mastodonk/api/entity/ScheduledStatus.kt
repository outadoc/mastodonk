package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledStatus(

    @SerialName("id")
    val statusId: String,

    @SerialName("scheduled_at")
    val scheduledAt: Instant,

    @SerialName("params")
    val params: StatusParams,

    @SerialName("media_attachments")
    val mediaAttachments: List<Attachment>
)
