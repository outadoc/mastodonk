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
    val remoteUrl: String?,

    @SerialName("text_url")
    val textUrl: String?,

    @SerialName("description")
    val description: String?,

    @SerialName("blurhash")
    val blurHash: String?
)