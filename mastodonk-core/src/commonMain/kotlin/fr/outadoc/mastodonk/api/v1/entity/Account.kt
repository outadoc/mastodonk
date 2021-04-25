package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.DateStringToLocalDateSerializer
import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Account(

    @SerialName("id")
    val id: String,

    @SerialName("username")
    val username: String,

    @SerialName("acct")
    val acct: String,

    @SerialName("url")
    val url: String,

    @SerialName("display_name")
    val displayName: String,

    @SerialName("note")
    val note: String,

    @SerialName("avatar")
    val avatar: String,

    @SerialName("avatar_static")
    val avatarStatic: String,

    @SerialName("header")
    val header: String,

    @SerialName("header_static")
    val headerStatic: String,

    @SerialName("locked")
    val isLocked: Boolean,

    @SerialName("emojis")
    val emojis: List<Emoji>,

    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,

    @SerialName("last_status_at")
    @Serializable(with = DateStringToLocalDateSerializer::class)
    val lastStatusAt: LocalDate,

    @SerialName("statuses_count")
    val statusesCount: Long,

    @SerialName("followers_count")
    val followersCount: Long,

    @SerialName("following_count")
    val followingCount: Long,

    @SerialName("discoverable")
    val isDiscoverable: Boolean? = null,

    @SerialName("moved")
    val isMoved: Boolean? = null,

    @SerialName("group")
    val isGroup: Boolean,

    @SerialName("fields")
    val fields: List<Field>? = null,

    @SerialName("bot")
    val isBot: Boolean? = null,

    @SerialName("source")
    val source: Source? = null,

    @SerialName("suspended")
    val isSuspended: Boolean? = null,

    @SerialName("mute_expires_at")
    @Serializable(with = InstantSerializer::class)
    val muteExpiresAt: Instant? = null
)
