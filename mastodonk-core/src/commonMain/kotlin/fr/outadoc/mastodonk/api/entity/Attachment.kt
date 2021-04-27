package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Attachment(

    @SerialName("id")
    val attachmentId: String,

    @SerialName("type")
    val type: AttachmentType,

    @SerialName("url")
    val url: String,

    @SerialName("preview_url")
    val previewUrl: String,

    @SerialName("remote_url")
    val remoteUrl: String? = null,

    @SerialName("preview_remote_url")
    val previewRemoteUrl: String? = null,

    @SerialName("text_url")
    val textUrl: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("blurhash")
    val blurHash: String? = null
)
