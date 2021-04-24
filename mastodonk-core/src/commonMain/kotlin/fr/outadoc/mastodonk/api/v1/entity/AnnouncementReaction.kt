package fr.outadoc.mastodonk.api.v1.entity

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
    val url: String?,

    @SerialName("static_url")
    val staticUrl: String?
)