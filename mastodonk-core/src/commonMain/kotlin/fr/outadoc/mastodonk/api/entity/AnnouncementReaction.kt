package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an emoji reaction to an [Announcement].
 */
@Serializable
public data class AnnouncementReaction(

    /**
     * The emoji used for the reaction.
     *
     * Either a unicode emoji, or a custom emoji's shortcode.
     */
    @SerialName("name")
    val name: String,

    /**
     * The total number of users who have added this reaction.
     */
    @SerialName("count")
    val count: Long,

    /**
     * Whether the authorized user has added this reaction to the announcement.
     */
    @SerialName("me")
    val me: Boolean,

    /**
     * URL to the custom emoji.
     */
    @SerialName("url")
    val url: String? = null,

    /**
     * URL to a non-animated version of the custom emoji.
     */
    @SerialName("static_url")
    val staticUrl: String? = null
)
