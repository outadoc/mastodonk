package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.GrantType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenCreate(

    /**
     * Client ID, obtained during app registration.
     */
    @SerialName("client_id")
    val clientId: String,

    /**
     * Client secret, obtained during app registration.
     */
    @SerialName("client_secret")
    val clientSecret: String,

    /**
     * URI to redirect the user to.
     *
     * If this parameter is set to `urn:ietf:wg:oauth:2.0:oob`
     * then the token will be shown instead.
     *
     * Must match one of the redirect URIs declared during app registration.
     */
    @SerialName("redirect_uri")
    val redirectUri: String,

    /**
     * Grant type, set to [GrantType.AuthorizationCode] if code
     * is provided in order to gain user-level access.
     *
     * Otherwise, set equal to [GrantType.ClientCredentials] to
     * obtain app-level access only.
     */
    @SerialName("grant_type")
    val grantType: GrantType,

    /**
     * List of requested OAuth scopes, separated by spaces.
     *
     * Must be a subset of scopes declared during app registration.
     * If not provided, defaults to read.
     */
    @SerialName("scope")
    val scope: String?,

    /**
     * A user authorization code, obtained via /oauth/authorize.
     */
    @SerialName("code")
    val code: String?
)
