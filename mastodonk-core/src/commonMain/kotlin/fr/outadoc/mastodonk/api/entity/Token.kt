package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an OAuth token used for authenticating with the API and performing actions.
 */
@Serializable
public data class Token(

    /**
     * An OAuth access token to be used for authorization.
     */
    @SerialName("access_token")
    val accessToken: String,

    /**
     * The OAuth token type. Mastodon uses `Bearer` tokens.
     */
    @SerialName("token_type")
    val tokenType: String,

    /**
     * The OAuth scopes granted by this token, space-separated.
     */
    @SerialName("scope")
    val scope: String,

    /**
     * Time at which the token was generated.
     */
    @SerialName("created_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val createdAt: Instant
)
