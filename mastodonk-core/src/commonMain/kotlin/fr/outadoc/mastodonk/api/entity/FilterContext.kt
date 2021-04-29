package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FilterContext {

    /**
     * Home timeline and lists.
     */
    @SerialName("home")
    Home,

    /**
     * Notifications timeline.
     */
    @SerialName("notifications")
    Notifications,

    /**
     * Public timelines.
     */
    @SerialName("public")
    Public,

    /**
     * Expanded thread of a detailed status.
     */
    @SerialName("thread")
    Thread
}
