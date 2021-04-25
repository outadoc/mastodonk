package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Card(

    @SerialName("url")
    val url: String,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("type")
    val type: CardType,

    @SerialName("author_name")
    val authorName: String? = null,

    @SerialName("author_url")
    val authorUrl: String? = null,

    @SerialName("provider_name")
    val providerName: String? = null,

    @SerialName("provider_url")
    val providerUrl: String? = null,

    @SerialName("html")
    val html: String? = null,

    @SerialName("width")
    val width: Long? = null,

    @SerialName("height")
    val height: Long? = null,

    @SerialName("image")
    val image: String? = null,

    @SerialName("embed_url")
    val embedUrl: String? = null,

    @SerialName("blurhash")
    val blurHash: String? = null
)
