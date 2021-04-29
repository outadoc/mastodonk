package fr.outadoc.mastodonk.api.entity.request.statuses

import fr.outadoc.mastodonk.api.entity.Visibility
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledStatusCreate(

    /**
     * Date at which the status will be sent.
     *
     * Must be at least 5 minutes in the future.
     */
    @SerialName("scheduled_at")
    val scheduledAt: Instant,

    /**
     * Text content of the status.
     *
     * If [mediaIds] is provided, this becomes optional.
     * Attaching a [poll] is optional while [status] is provided.
     */
    @SerialName("status")
    val status: String? = null,

    /**
     * Array of attachment ids to be attached as media.
     *
     * If provided, [status] becomes optional, and [poll] cannot be used.
     */
    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    @SerialName("poll")
    val poll: PollCreate? = null,

    /**
     * ID of the status being replied to, if status is a reply.
     */
    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    /**
     * Mark status and attached media as sensitive?
     */
    @SerialName("sensitive")
    val isSensitive: Boolean? = null,

    /**
     * Text to be shown as a warning or subject before the actual content.
     *
     * Statuses are generally collapsed behind this field.
     */
    @SerialName("spoiler_text")
    val spoilerText: String? = null,

    /**
     * Visibility of the posted status.
     */
    @SerialName("visibility")
    val visibility: Visibility? = null,

    /**
     * ISO 639 language code for this status.
     */
    @SerialName("language")
    val language: String? = null
)
