package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a file or media attachment that can be added to a status.
 */
@Serializable
public sealed class Attachment {

    public abstract val attachmentId: String

    /**
     * URL of the original full-size attachment.
     */
    public abstract val url: String

    /**
     * URL of a scaled-down preview of the attachment.
     */
    public abstract val previewUrl: String?

    /**
     * URL of the full-size original attachment on the remote website.
     */
    public abstract val remoteUrl: String?

    /**
     * URL of a scaled-down preview of the attachment on the remote website.
     */
    public abstract val previewRemoteUrl: String?

    /**
     * A shorter URL for the attachment.
     */
    public abstract val textUrl: String?

    /**
     * Alternate text that describes what is in the media attachment.
     *
     * To be used for the visually impaired or when media attachments do not load.
     */
    public abstract val description: String?

    /**
     * A hash computed by the BlurHash algorithm, for generating
     * colorful preview thumbnails when media has not been downloaded yet.
     */
    public abstract val blurHash: String?

    @Serializable
    @SerialName("image")
    public data class Image(

        @SerialName("id")
        public override val attachmentId: String,

        @SerialName("url")
        public override val url: String,

        @SerialName("preview_url")
        public override val previewUrl: String? = null,

        @SerialName("remote_url")
        public override val remoteUrl: String? = null,

        @SerialName("preview_remote_url")
        public override val previewRemoteUrl: String? = null,

        @SerialName("text_url")
        public override val textUrl: String? = null,

        @SerialName("description")
        public override val description: String? = null,

        @SerialName("blurhash")
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta = Meta()
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

    @Serializable
    @SerialName("video")
    public data class Video(

        @SerialName("id")
        public override val attachmentId: String,

        @SerialName("url")
        public override val url: String,

        @SerialName("preview_url")
        public override val previewUrl: String? = null,

        @SerialName("remote_url")
        public override val remoteUrl: String? = null,

        @SerialName("preview_remote_url")
        public override val previewRemoteUrl: String? = null,

        @SerialName("text_url")
        public override val textUrl: String? = null,

        @SerialName("description")
        public override val description: String? = null,

        @SerialName("blurhash")
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta = Meta()
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

    @Serializable
    @SerialName("gifv")
    public data class Gifv(

        @SerialName("id")
        public override val attachmentId: String,

        @SerialName("url")
        public override val url: String,

        @SerialName("preview_url")
        public override val previewUrl: String? = null,

        @SerialName("remote_url")
        public override val remoteUrl: String? = null,

        @SerialName("preview_remote_url")
        public override val previewRemoteUrl: String? = null,

        @SerialName("text_url")
        public override val textUrl: String? = null,

        @SerialName("description")
        public override val description: String? = null,

        @SerialName("blurhash")
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta = Meta()
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

    @Serializable
    @SerialName("audio")
    public data class Audio(

        @SerialName("id")
        public override val attachmentId: String,

        @SerialName("url")
        public override val url: String,

        @SerialName("preview_url")
        public override val previewUrl: String? = null,

        @SerialName("remote_url")
        public override val remoteUrl: String? = null,

        @SerialName("preview_remote_url")
        public override val previewRemoteUrl: String? = null,

        @SerialName("text_url")
        public override val textUrl: String? = null,

        @SerialName("description")
        public override val description: String? = null,

        @SerialName("blurhash")
        public override val blurHash: String? = null,

        @SerialName("meta")
        public val meta: Meta = Meta()
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

    @Serializable
    @SerialName("unknown")
    public data class Unknown(

        @SerialName("id")
        public override val attachmentId: String,

        @SerialName("url")
        public override val url: String,

        @SerialName("preview_url")
        public override val previewUrl: String? = null,

        @SerialName("remote_url")
        public override val remoteUrl: String? = null,

        @SerialName("preview_remote_url")
        public override val previewRemoteUrl: String? = null,

        @SerialName("text_url")
        public override val textUrl: String? = null,

        @SerialName("description")
        public override val description: String? = null,

        @SerialName("blurhash")
        public override val blurHash: String? = null,
    ) : Attachment()
}
