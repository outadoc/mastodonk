package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.StatusVisibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to post a new [Status].
 */
@Serializable
public data class StatusCreate(

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
    val contentWarningText: String? = null,

    /**
     * Visibility of the posted status.
     */
    @SerialName("visibility")
    val visibility: StatusVisibility? = null,

    /**
     * ISO 639-1 language code for this status.
     */
    @SerialName("language")
    val language: String? = null
)
