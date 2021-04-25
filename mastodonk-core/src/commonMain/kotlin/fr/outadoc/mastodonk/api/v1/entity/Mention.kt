package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Mention(

    @SerialName("id")
    val id: String,

    @SerialName("username")
    val username: String,

    @SerialName("acct")
    val acct: String,

    @SerialName("url")
    val url: String
)
