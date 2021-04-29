package fr.outadoc.mastodonk.auth

/**
 * Token used for API request authentication.
 */
public data class AuthToken(

    /**
     * An OAuth access token to be used for authorization.
     */
    val accessToken: String,

    /**
     * The token type. Usually `Bearer`
     */
    val type: String = "Bearer"
) {
    override fun toString(): String = "$type $accessToken"
}
