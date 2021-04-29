package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the relationship between accounts.
 */
@Serializable
public data class Relationship(

    /**
     * ID of the account being examined.
     */
    @SerialName("id")
    val accountId: String,

    /**
     * Whether the current account is following this account.
     */
    @SerialName("following")
    val isFollowing: Boolean,

    /**
     * Whether the current account has a pending follow request for this account.
     */
    @SerialName("requested")
    val hasPendingFollowRequest: Boolean,

    /**
     * Whether the current account is featuring this account on their profile.
     */
    @SerialName("endorsed")
    val isFeatured: Boolean,

    /**
     * Whether the current account is being followed by this account.
     */
    @SerialName("followed_by")
    val isFollowedBy: Boolean,

    /**
     * Whether the current account has muted this account.
     */
    @SerialName("muting")
    val isMuting: Boolean,

    /**
     * Whether the current account has muted notifications for this account.
     */
    @SerialName("muting_notifications")
    val isMutingNotifications: Boolean,

    /**
     * Whether the current account is showing boosts from this account.
     */
    @SerialName("showing_reblogs")
    val isShowingBoosts: Boolean,

    /**
     * Whether the current account has enabled notifications for this account.
     */
    @SerialName("notifying")
    val isNotifying: Boolean,

    /**
     * Whether the current account is blocking this account.
     */
    @SerialName("blocking")
    val isBlocking: Boolean,

    /**
     * Whether the current account is blocking this account's domain.
     */
    @SerialName("domain_blocking")
    val isDomainBlocking: Boolean,

    /**
     * Whether the current account is being blocked by this account.
     */
    @SerialName("blocked_by")
    val isBlockedBy: Boolean,

    /**
     * A private comment left by the current account on this account.
     */
    @SerialName("note")
    val note: String
)
