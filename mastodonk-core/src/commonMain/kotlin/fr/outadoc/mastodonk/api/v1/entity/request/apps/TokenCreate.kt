package fr.outadoc.mastodonk.api.v1.entity.request.apps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenCreate(

    @SerialName("client_id")
    val clientId: String,

    @SerialName("client_secret")
    val clientSecret: String,

    @SerialName("redirect_uri")
    val redirectUri: String,

    @SerialName("grant_type")
    val grantType: String,

    @SerialName("scope")
    val scope: String?,

    @SerialName("code")
    val code: String?
)
