package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
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

    @SerialName("discoverable")
    val isDiscoverable: Boolean,

    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,

    @SerialName("last_status_at")
    @Serializable(with = InstantSerializer::class)
    val lastStatusAt: Instant,

    @SerialName("statuses_count")
    val statusesCount: Long,

    @SerialName("followers_count")
    val followersCount: Long,

    @SerialName("following_count")
    val followingCount: Long,

    @SerialName("moved")
    val isMoved: Boolean?,

    @SerialName("fields")
    val fields: List<Field>?,

    @SerialName("bot")
    val isBot: Boolean?,

    @SerialName("source")
    val source: Source?,

    @SerialName("suspended")
    val isSuspended: Boolean?,

    @SerialName("mute_expires_at")
    @Serializable(with = InstantSerializer::class)
    val muteExpiresAt: Instant?
)