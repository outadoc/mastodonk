package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FilterContext {
    @SerialName("home")
    Home,

    @SerialName("notifications")
    Notifications,

    @SerialName("public")
    Public,

    @SerialName("thread")
    Thread
}
