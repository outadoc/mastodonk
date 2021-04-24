package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StatusParams(

    @SerialName("text")
    val text: String,

    @SerialName("visibility")
    val visibility: Visibility,

    @SerialName("application_id")
    val applicationId: String,

    @SerialName("in_reply_to_id")
    val inReplyToId: String?,

    @SerialName("media_ids")
    val mediaIds: List<String>?,

    @SerialName("sensitive")
    val isSensitive: Boolean?,

    @SerialName("spoiler_text")
    val spoilerText: String?,

    @SerialName("scheduled_at")
    @Serializable(with = InstantSerializer::class)
    val scheduledAt: Instant?
)