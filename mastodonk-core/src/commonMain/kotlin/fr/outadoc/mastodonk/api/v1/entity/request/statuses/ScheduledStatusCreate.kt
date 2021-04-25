package fr.outadoc.mastodonk.api.v1.entity.request.statuses

import fr.outadoc.mastodonk.api.v1.entity.Visibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledStatusCreate(

    @SerialName("status")
    val status: String? = null,

    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    @SerialName("poll")
    val poll: PollCreate? = null,

    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    @SerialName("sensitive")
    val isSensitive: Boolean? = null,

    @SerialName("spoiler_text")
    val spoilerText: String? = null,

    @SerialName("visibility")
    val visibility: Visibility? = null,

    @SerialName("language")
    val language: String? = null
)
