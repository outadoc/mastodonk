package fr.outadoc.mastodonk.api.v1.entity.request.accounts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountCreate(

    @SerialName("username")
    val username: String,

    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String,

    @SerialName("agreement")
    val agreement: String,

    @SerialName("locale")
    val locale: String,

    @SerialName("reason")
    val reason: String? = null
)
