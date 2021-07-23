package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a status that will be published at a future scheduled date.
 */
@Serializable
public data class ScheduledStatus(

    @SerialName("id")
    val statusId: String,

    /**
     * Time at which the status should be posted.
     */
    @SerialName("scheduled_at")
    val scheduledAt: Instant,

    /**
     * Status details.
     */
    @SerialName("params")
    val params: ScheduledStatusParams,

    /**
     * Media attached to this status.
     */
    @SerialName("media_attachments")
    val mediaAttachments: List<Attachment>
) : Pageable {

    override val id: String
        get() = statusId
}
