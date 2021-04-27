package fr.outadoc.mastodonk.api.entity.request.apps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApplicationCreate(

    /**
     * A name for your application.
     */
    @SerialName("client_name")
    val clientName: String,

    /**
     * Where the user should be redirected after authorization.
     *
     * To display the authorization code to the user instead of
     * redirecting to a web page, use `urn:ietf:wg:oauth:2.0:oob` in this parameter.
     */
    @SerialName("redirect_uris")
    val redirectUris: String,

    /**
     * Space-separated list of scopes.
     *
     * If none is provided, defaults to `read`.
     */
    @SerialName("scopes")
    val scopes: String?,

    /**
     * A URL to the homepage of your app.
     */
    @SerialName("website")
    val website: String?
)
