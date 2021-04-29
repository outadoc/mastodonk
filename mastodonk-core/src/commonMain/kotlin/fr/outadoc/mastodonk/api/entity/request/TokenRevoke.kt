package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Token
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to revoke a [Token].
 */
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
