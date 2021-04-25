package fr.outadoc.mastodonk.api.v1.entity.request.apps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApplicationCreate(

    @SerialName("client_name")
    val clientName: String,

    @SerialName("redirect_uris")
    val redirectUris: String,

    @SerialName("scopes")
    val scopes: String?,

    @SerialName("website")
    val website: String?
)
