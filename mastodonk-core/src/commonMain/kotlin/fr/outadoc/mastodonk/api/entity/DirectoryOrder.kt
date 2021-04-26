package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DirectoryOrder {

    @SerialName("active")
    Active,

    @SerialName("new")
    New
}
