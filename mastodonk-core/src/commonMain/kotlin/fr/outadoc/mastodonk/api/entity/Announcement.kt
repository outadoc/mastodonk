package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an announcement set by an administrator.
 */
@Serializable
public data class Announcement(

    @SerialName("id")
    val announcementId: String,

    /**
     * The content of the announcement.
     */
    @SerialName("text")
    val text: String,

    /**
     * Whether the announcement is currently active.
     */
    @SerialName("published")
    val isPublished: Boolean,

    /**
     * Whether the announcement has a start/end time.
     */
    @SerialName("all_day")
    val isAllDay: Boolean,

    /**
     * Moment at which the announcement was created.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * Moment at which the announcement was last updated.
     */
    @SerialName("updated_at")
    val updatedAt: Instant,

    /**
     * Whether the announcement has been read by the user.
     */
    @SerialName("read")
    val isRead: Boolean,

    /**
     * Emoji reactions attached to the announcement.
     */
    @SerialName("reactions")
    val reactions: List<AnnouncementReaction>,

    /**
     * Time at which a scheduled announcement was scheduled.
     */
    @SerialName("scheduled_at")
    val scheduledAt: Instant? = null,

    /**
     * Time at which the announcement will start.
     */
    @SerialName("starts_at")
    val startsAt: Instant? = null,

    /**
     * Time at which the announcement will end.
     */
    @SerialName("ends_at")
    val endsAt: Instant? = null
)
