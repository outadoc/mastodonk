package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parameters for a [ScheduledStatus].
 */
@Serializable
public data class ScheduledStatusParams(

    /**
     * Plain-text content of the status.
     */
    @SerialName("text")
    val plainText: String,

    /**
     * Visibility of this status.
     */
    @SerialName("visibility")
    val visibility: StatusVisibility,

    /**
     * The ID of the application that created this status.
     */
    @SerialName("application_id")
    val applicationId: String,

    /**
     * ID of the status being replied to, if status is a reply.
     */
    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    /**
     * Array of attachment ids to be attached as media.
     */
    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    /**
     * Is this status marked as sensitive content?
     */
    @SerialName("sensitive")
    val isSensitive: Boolean? = null,

    /**
     * Subject or summary line, below which status content is collapsed until expanded.
     */
    @SerialName("spoiler_text")
    val contentWarningText: String? = null,

    @SerialName("scheduled_at")
    val scheduledAt: Instant? = null
)
