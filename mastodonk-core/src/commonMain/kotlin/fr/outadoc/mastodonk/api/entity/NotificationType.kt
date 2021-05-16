package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class NotificationType(public val value: String) {

    /**
     * Someone followed the account.
     */
    @SerialName("follow")
    Follow("follow"),

    /**
     * Someone requested to follow the account.
     */
    @SerialName("follow_request")
    FollowRequest("follow_request"),

    /**
     * Someone mentioned the account in their status.
     */
    @SerialName("mention")
    Mention("mention"),

    /**
     * Someone boosted one of the account's statuses.
     */
    @SerialName("reblog")
    Boost("reblog"),

    /**
     * Someone favourited one of the account's statuses.
     */
    @SerialName("favourite")
    Favourite("favourite"),

    /**
     * A poll the account has voted in or created has ended.
     */
    @SerialName("poll")
    Poll("poll"),

    /**
     * Someone we enabled notifications for has posted a status.
     */
    @SerialName("status")
    Status("status")
}
