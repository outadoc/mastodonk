package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DirectoryOrder(public val value: String) {

    /**
     * Sort by most recently posted statuses.
     */
    @SerialName("active")
    Active("active"),

    /**
     * Sort by most recently created accounts.
     */
    @SerialName("new")
    New("new")
}
