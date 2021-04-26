package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ActionType {

    @SerialName("none")
    None,

    @SerialName("disable")
    Disable,

    @SerialName("silence")
    Silence,

    @SerialName("suspend")
    Suspend
}
