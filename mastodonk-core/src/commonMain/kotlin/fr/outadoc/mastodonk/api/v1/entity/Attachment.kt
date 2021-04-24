package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Attachment(

    @SerialName("id")
    val id: String,

    @SerialName("type")
    val type: AttachmentType,

    @SerialName("url")
    val url: String,

    @SerialName("preview_url")
    val previewUrl: String,

    @SerialName("remote_url")
    val remoteUrl: String? = null,

    @SerialName("text_url")
    val textUrl: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("blurhash")
    val blurHash: String? = null
)