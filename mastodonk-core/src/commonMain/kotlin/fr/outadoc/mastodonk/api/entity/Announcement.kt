package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Announcement(

    @SerialName("id")
    val announcementId: String,

    @SerialName("text")
    val text: String,

    @SerialName("published")
    val isPublished: Boolean,

    @SerialName("all_day")
    val isAllDay: Boolean,

    @SerialName("created_at")
    val createdAt: Instant,

    @SerialName("updated_at")
    val updatedAt: Instant,

    @SerialName("read")
    val isRead: Boolean,

    @SerialName("reactions")
    val reactions: List<AnnouncementReaction>,

    @SerialName("scheduled_at")
    val scheduledAt: Instant? = null,

    @SerialName("starts_at")
    val startsAt: Instant? = null,

    @SerialName("ends_at")
    val endsAt: Instant? = null
)
