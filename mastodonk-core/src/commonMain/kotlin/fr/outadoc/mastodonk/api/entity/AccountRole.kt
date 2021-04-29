package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The different roles that can be attributed to an [Account].
 */
@Serializable
public enum class AccountRole {

    @SerialName("admin")
    Admin,

    @SerialName("moderator")
    Moderator,

    @SerialName("user")
    User
}
