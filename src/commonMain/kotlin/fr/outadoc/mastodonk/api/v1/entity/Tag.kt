package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Tag(

    @SerialName("name")
    val name: String,

    @SerialName("url")
    val url: String,

    @SerialName("history")
    val history: List<History>
)