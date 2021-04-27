package fr.outadoc.mastodonk.api.entity.request.apps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenRevoke(

    /**
     * Client ID, obtained during app registration
     */
    @SerialName("client_id")
    val clientId: String,

    /**
     * Client secret, obtained during app registration
     */
    @SerialName("client_secret")
    val clientSecret: String,

    /**
     * The previously obtained token, to be invalidated
     */
    @SerialName("token")
    val token: String,
)
