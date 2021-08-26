package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a file or media attachment that can be added to a status.
 */
@Serializable
public sealed class Attachment {

    @SerialName("id")
    public abstract val attachmentId: String

    /**
     * The type of the attachment.
     */
    @SerialName("type")
    public abstract val type: String

    /**
     * URL of the original full-size attachment.
     */
    @SerialName("url")
    public abstract val url: String

    /**
     * URL of a scaled-down preview of the attachment.
     */
    @SerialName("preview_url")
    public abstract val previewUrl: String?

    /**
     * URL of the full-size original attachment on the remote website.
     */
    @SerialName("remote_url")
    public abstract val remoteUrl: String?

    /**
     * URL of a scaled-down preview of the attachment on the remote website.
     */
    @SerialName("preview_remote_url")
    public abstract val previewRemoteUrl: String?

    /**
     * A shorter URL for the attachment.
     */
    @SerialName("text_url")
    public abstract val textUrl: String?

    /**
     * Alternate text that describes what is in the media attachment.
     *
     * To be used for the visually impaired or when media attachments do not load.
     */
    @SerialName("description")
    public abstract val description: String?

    /**
     * A hash computed by the BlurHash algorithm, for generating
     * colorful preview thumbnails when media has not been downloaded yet.
     */
    @SerialName("blurhash")
    public abstract val blurHash: String?

    @SerialName("image")
    public data class Image(
        public override val attachmentId: String,
        public override val type: String,
        public override val url: String,
        public override val previewUrl: String? = null,
        public override val remoteUrl: String? = null,
        public override val previewRemoteUrl: String? = null,
        public override val textUrl: String? = null,
        public override val description: String? = null,
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta
    ) : Attachment() {

        @Serializable
        public data class Meta(

            @SerialName("width")
            val width: Long? = null,

            @SerialName("height")
            val height: Long? = null,

            @SerialName("aspect")
            val aspect: Double? = null,

            @SerialName("focus")
            val focalPoint: FocalPoint? = null,

            @SerialName("original")
            val original: Meta? = null,

            @SerialName("small")
            val small: Meta? = null
        )
    }

    @SerialName("video")
    public data class Video(
        public override val attachmentId: String,
        public override val type: String,
        public override val url: String,
        public override val previewUrl: String? = null,
        public override val remoteUrl: String? = null,
        public override val previewRemoteUrl: String? = null,
        public override val textUrl: String? = null,
        public override val description: String? = null,
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta
    ) : Attachment() {

        @Serializable
        public data class Meta(

            @SerialName("width")
            val width: Long? = null,

            @SerialName("height")
            val height: Long? = null,

            @SerialName("aspect")
            val aspect: Double? = null,

            @SerialName("duration")
            val durationSeconds: Double? = null,

            @SerialName("fps")
            val fps: Long? = null,

            @SerialName("audio_encode")
            val audioCodec: String? = null,

            @SerialName("audio_bitrate")
            val audioBitrate: String? = null,

            @SerialName("audio_channels")
            val audioChannels: String? = null,

            @SerialName("bitrate")
            val bitrate: Long? = null,

            @SerialName("original")
            val original: Meta? = null,

            @SerialName("small")
            val small: Meta? = null
        )
    }

    @SerialName("gifv")
    public data class Gifv(
        public override val attachmentId: String,
        public override val type: String,
        public override val url: String,
        public override val previewUrl: String? = null,
        public override val remoteUrl: String? = null,
        public override val previewRemoteUrl: String? = null,
        public override val textUrl: String? = null,
        public override val description: String? = null,
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta
    ) : Attachment() {

        @Serializable
        public data class Meta(

            @SerialName("width")
            val width: Long? = null,

            @SerialName("height")
            val height: Long? = null,

            @SerialName("aspect")
            val aspect: Double? = null,

            @SerialName("duration")
            val durationSeconds: Double? = null,

            @SerialName("fps")
            val fps: Long? = null,

            @SerialName("bitrate")
            val bitrate: Long? = null,

            @SerialName("original")
            val original: Meta? = null,

            @SerialName("small")
            val small: Meta? = null
        )
    }

    @SerialName("audio")
    public data class Audio(
        public override val attachmentId: String,
        public override val type: String,
        public override val url: String,
        public override val previewUrl: String? = null,
        public override val remoteUrl: String? = null,
        public override val previewRemoteUrl: String? = null,
        public override val textUrl: String? = null,
        public override val description: String? = null,
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta
    ) : Attachment() {

        @Serializable
        public data class Meta(

            @SerialName("duration")
            val durationSeconds: Double? = null,

            @SerialName("audio_encode")
            val audioCodec: String? = null,

            @SerialName("audio_bitrate")
            val audioBitrate: String? = null,

            @SerialName("audio_channels")
            val audioChannels: String? = null,

            @SerialName("bitrate")
            val bitrate: Long? = null,

            @SerialName("original")
            val original: Meta? = null
        )
    }

    @SerialName("unknown")
    public data class Unknown(
        public override val attachmentId: String,
        public override val type: String,
        public override val url: String,
        public override val previewUrl: String? = null,
        public override val remoteUrl: String? = null,
        public override val previewRemoteUrl: String? = null,
        public override val textUrl: String? = null,
        public override val description: String? = null,
        public override val blurHash: String? = null,
    ) : Attachment()
}
