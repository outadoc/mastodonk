package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AnnouncementReaction(

    @SerialName("name")
    val name: String,

    @SerialName("count")
    val count: Long,

    @SerialName("me")
    val me: Boolean,

    @SerialName("url")
    val url: String? = null,

    @SerialName("static_url")
    val staticUrl: String? = null
)
