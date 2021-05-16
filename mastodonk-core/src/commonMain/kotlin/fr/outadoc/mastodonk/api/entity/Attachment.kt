package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a file or media attachment that can be added to a status.
 */
@Serializable
public data class Attachment(

    @SerialName("id")
    val attachmentId: String,

    /**
     * The type of the attachment.
     */
    @SerialName("type")
    val type: AttachmentType,

    /**
     * URL of the original full-size attachment.
     */
    @SerialName("url")
    val url: String,

    /**
     * URL of a scaled-down preview of the attachment.
     */
    @SerialName("preview_url")
    val previewUrl: String? = null,

    /**
     * URL of the full-size original attachment on the remote website.
     */
    @SerialName("remote_url")
    val remoteUrl: String? = null,

    /**
     * URL of a scaled-down preview of the attachment on the remote website.
     */
    @SerialName("preview_remote_url")
    val previewRemoteUrl: String? = null,

    /**
     * A shorter URL for the attachment.
     */
    @SerialName("text_url")
    val textUrl: String? = null,

    /**
     * Alternate text that describes what is in the media attachment.
     *
     * To be used for the visually impaired or when media attachments do not load.
     */
    @SerialName("description")
    val description: String? = null,

    /**
     * A hash computed by the BlurHash algorithm, for generating
     * colorful preview thumbnails when media has not been downloaded yet.
     */
    @SerialName("blurhash")
    val blurHash: String? = null
)
