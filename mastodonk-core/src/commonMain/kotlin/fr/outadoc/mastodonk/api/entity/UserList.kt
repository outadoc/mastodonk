package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a list of some users that the authenticated user follows.
 */
@Serializable
public data class UserList(

    @SerialName("id")
    val listId: String,

    /**
     * The user-defined title of the list.
     */
    @SerialName("title")
    val title: String,

    /**
     * The reply policy of this list.
     */
    @SerialName("replies_policy")
    val replyPolicy: ListReplyPolicy
)
