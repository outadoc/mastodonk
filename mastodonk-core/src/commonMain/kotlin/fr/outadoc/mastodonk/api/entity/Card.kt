package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a rich preview card that is generated
 * using OpenGraph tags from a URL.
 */
@Serializable
public sealed class Card {

    /**
     * URL of linked resource.
     */
    public abstract val url: String

    /**
     * Title of linked resource.
     */
    public abstract val title: String

    /**
     * Description of preview.
     */
    public abstract val description: String

    @Serializable
    @SerialName("video")
    public data class Video(

        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String,

        /**
         * The author of the original resource.
         */
        @SerialName("author_name")
        val authorName: String? = null,

        /**
         * URL to the author of the original resource.
         */
        @SerialName("author_url")
        val authorUrl: String? = null,

        /**
         * The provider of the original resource.
         */
        @SerialName("provider_name")
        val providerName: String? = null,

        /**
         * URL to the provider of the original resource.
         */
        @SerialName("provider_url")
        val providerUrl: String? = null,

        /**
         * HTML to be used for generating the preview card.
         */
        @SerialName("html")
        val html: String? = null,

        /**
         * Width of preview, in pixels.
         */
        @SerialName("width")
        val width: Long? = null,

        /**
         * Height of preview, in pixels.
         */
        @SerialName("height")
        val height: Long? = null,

        /**
         * URL of a preview thumbnail.
         */
        @SerialName("image")
        val image: String? = null,

        /**
         * A hash computed by the BlurHash algorithm.
         *
         * For generating colorful preview thumbnails when media
         * has not been downloaded yet.
         */
        @SerialName("blurhash")
        val blurHash: String? = null

    ) : Card()


    @Serializable
    @SerialName("photo")
    public data class Photo(

        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String,

        /**
         * The author of the original resource.
         */
        @SerialName("author_name")
        val authorName: String? = null,

        /**
         * URL to the author of the original resource.
         */
        @SerialName("author_url")
        val authorUrl: String? = null,

        /**
         * The provider of the original resource.
         */
        @SerialName("provider_name")
        val providerName: String? = null,

        /**
         * URL to the provider of the original resource.
         */
        @SerialName("provider_url")
        val providerUrl: String? = null,

        /**
         * Width of preview, in pixels.
         */
        @SerialName("width")
        val width: Long? = null,

        /**
         * Height of preview, in pixels.
         */
        @SerialName("height")
        val height: Long? = null,

        /**
         * URL of a preview thumbnail.
         */
        @SerialName("image")
        val image: String? = null,

        /**
         * URL used for photo embeds, instead of custom HTML.
         */
        @SerialName("embed_url")
        val embedUrl: String? = null,

        /**
         * A hash computed by the BlurHash algorithm.
         *
         * For generating colorful preview thumbnails when media
         * has not been downloaded yet.
         */
        @SerialName("blurhash")
        val blurHash: String? = null

    ) : Card()

    @Serializable
    @SerialName("link")
    public data class Link(

        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String

    ) : Card()

    @Serializable
    @SerialName("rich")
    public data class Rich(

        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String

    ) : Card()
}
