package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Relationship(

    @SerialName("id")
    val id: String,

    @SerialName("following")
    val isFollowing: Boolean,

    @SerialName("requested")
    val isRequested: Boolean,

    @SerialName("endorsed")
    val isEndorsed: Boolean,

    @SerialName("followed_by")
    val isFollowedBy: Boolean,

    @SerialName("muting")
    val isMuting: Boolean,

    @SerialName("muting_notifications")
    val isMutingNotifications: Boolean,

    @SerialName("showing_reblogs")
    val isShowingReblogs: Boolean,

    @SerialName("notifying")
    val isNotifying: Boolean,

    @SerialName("blocking")
    val isBlocking: Boolean,

    @SerialName("domain_blocking")
    val isDomainBlocking: Boolean,

    @SerialName("blocked_by")
    val isBlockedBy: Boolean,

    @SerialName("note")
    val note: String
)
