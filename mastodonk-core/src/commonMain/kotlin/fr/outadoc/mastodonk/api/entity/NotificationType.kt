package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class NotificationType {

    @SerialName("follow")
    Follow,

    @SerialName("follow_request")
    FollowRequest,

    @SerialName("mention")
    Mention,

    @SerialName("reblog")
    Boost,

    @SerialName("favourite")
    Favourite,

    @SerialName("poll")
    Poll,

    @SerialName("status")
    Status
}
