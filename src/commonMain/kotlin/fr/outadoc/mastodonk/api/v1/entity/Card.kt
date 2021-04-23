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
    val authorName: String?,

    @SerialName("author_url")
    val authorUrl: String?,

    @SerialName("provider_name")
    val providerName: String?,

    @SerialName("provider_url")
    val providerUrl: String?,

    @SerialName("html")
    val html: String?,

    @SerialName("width")
    val width: String?,

    @SerialName("height")
    val height: String?,

    @SerialName("image")
    val image: String?,

    @SerialName("embed_url")
    val embedUrl: String?,

    @SerialName("blurhash")
    val blurHash: String?
)