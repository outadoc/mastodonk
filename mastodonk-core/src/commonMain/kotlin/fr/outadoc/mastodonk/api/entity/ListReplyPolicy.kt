package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Reply policy set on a [UserList].
 */
@Serializable
public enum class ListReplyPolicy {

    /**
     * Show replies to any followed user.
     */
    @SerialName("followed")
    Followed,

    /**
     * Show replies to members of the list.
     */
    @SerialName("list")
    List,

    /**
     * Show replies to no one.
     */
    @SerialName("none")
    None
}
