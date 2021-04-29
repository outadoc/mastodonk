package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of moderating action to be taken.
 */
@Serializable
public enum class ActionType {

    /**
     * No action.
     */
    @SerialName("none")
    None,

    /**
     * Disable the account.
     */
    @SerialName("disable")
    Disable,

    /**
     * Silence the account.
     */
    @SerialName("silence")
    Silence,

    /**
     * Suspend the account.
     */
    @SerialName("suspend")
    Suspend
}
