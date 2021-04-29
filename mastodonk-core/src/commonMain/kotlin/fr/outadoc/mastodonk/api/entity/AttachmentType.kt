package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Attachment media type.
 */
@Serializable
public enum class AttachmentType {

    /**
     * Unsupported or unrecognized file type.
     */
    @SerialName("unknown")
    Unknown,

    /**
     * Static image.
     */
    @SerialName("image")
    Image,

    /**
     * Looping, soundless animation.
     */
    @SerialName("gifv")
    Gifv,

    /**
     * Video clip.
     */
    @SerialName("video")
    Video,

    /**
     * Audio track.
     */
    @SerialName("audio")
    Audio
}
