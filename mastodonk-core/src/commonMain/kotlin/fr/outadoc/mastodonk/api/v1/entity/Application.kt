package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Application(

    @SerialName("name")
    val name: String,

    @SerialName("website")
    val website: String? = null,

    @SerialName("vapid_key")
    val vapidKey: String? = null,

    @SerialName("client_id")
    val clientId: String? = null,

    @SerialName("client_secret")
    val clientSecret: String? = null,
)
