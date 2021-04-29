package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Token(

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("token_type")
    val tokenType: String,

    @SerialName("scope")
    val scope: String,

    @SerialName("created_at")
    val createdAt: Instant
)
