package fr.outadoc.mastodonk.api.v1.entity.request.apps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenRevoke(

    @SerialName("client_id")
    val clientId: String,

    @SerialName("client_secret")
    val clientSecret: String,

    @SerialName("token")
    val token: String,
)