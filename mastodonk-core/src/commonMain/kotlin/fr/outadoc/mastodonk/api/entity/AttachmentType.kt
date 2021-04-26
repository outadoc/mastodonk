package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AttachmentType {

    @SerialName("unknown")
    Unknown,

    @SerialName("image")
    Image,

    @SerialName("gifv")
    Gifv,

    @SerialName("video")
    Video,

    @SerialName("audio")
    Audio
}
