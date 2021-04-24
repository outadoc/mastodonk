package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Announcement(

    @SerialName("id")
    val id: String,

    @SerialName("text")
    val text: String,

    @SerialName("published")
    val isPublished: Boolean,

    @SerialName("all_day")
    val isAllDay: Boolean,

    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,

    @SerialName("updated_at")
    @Serializable(with = InstantSerializer::class)
    val updatedAt: Instant,

    @SerialName("read")
    val isRead: Boolean,

    @SerialName("reactions")
    val reactions: List<AnnouncementReaction>,

    @SerialName("scheduled_at")
    @Serializable(with = InstantSerializer::class)
    val scheduledAt: Instant? = null,

    @SerialName("starts_at")
    @Serializable(with = InstantSerializer::class)
    val startsAt: Instant? = null,

    @SerialName("ends_at")
    @Serializable(with = InstantSerializer::class)
    val endsAt: Instant? = null
)