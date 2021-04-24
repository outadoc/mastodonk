package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Role {

    @SerialName("admin")
    Admin,

    @SerialName("moderator")
    Moderator,

    @SerialName("user")
    User
}
