package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class NotificationType {

    /**
     * Someone followed the account.
     */
    @SerialName("follow")
    Follow,

    /**
     * Someone requested to follow the account.
     */
    @SerialName("follow_request")
    FollowRequest,

    /**
     * Someone mentioned the account in their status.
     */
    @SerialName("mention")
    Mention,

    /**
     * Someone boosted one of the account's statuses.
     */
    @SerialName("reblog")
    Boost,

    /**
     * Someone favourited one of the account's statuses.
     */
    @SerialName("favourite")
    Favourite,

    /**
     * A poll the account has voted in or created has ended.
     */
    @SerialName("poll")
    Poll,

    /**
     * Someone we enabled notifications for has posted a status.
     */
    @SerialName("status")
    Status
}
