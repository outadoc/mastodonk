package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a status posted by an account.
 */
@Serializable
public data class Status(

    @SerialName("id")
    val statusId: String,

    /**
     * URI of the status used for federation.
     */
    @SerialName("uri")
    val uri: String,

    /**
     * The time when this status was created.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The account that authored this status.
     */
    @SerialName("account")
    val account: Account,

    /**
     * HTML-encoded status content.
     */
    @SerialName("content")
    val content: String,

    /**
     * Visibility of this status.
     */
    @SerialName("visibility")
    val visibility: StatusVisibility,

    /**
     * Is this status marked as sensitive content?
     */
    @SerialName("sensitive")
    val isSensitive: Boolean,

    /**
     * Subject or summary line, below which status content is collapsed until expanded.
     */
    @SerialName("spoiler_text")
    val contentWarningText: String,

    /**
     * Media that is attached to this status.
     */
    @SerialName("media_attachments")
    val mediaAttachments: List<Attachment>,

    /**
     * Mentions of users within the status content.
     */
    @SerialName("mentions")
    val mentions: List<Mention>,

    /**
     * Hashtags used within the status content.
     */
    @SerialName("tags")
    val tags: List<Tag>,

    /**
     * Custom emoji to be used when rendering status content.
     */
    @SerialName("emojis")
    val emojis: List<Emoji>,

    /**
     * How many boosts this status has received.
     */
    @SerialName("reblogs_count")
    val boostsCount: Long,

    /**
     * How many favourites this status has received.
     */
    @SerialName("favourites_count")
    val favouritesCount: Long,

    /**
     * How many replies this status has received.
     */
    @SerialName("replies_count")
    val repliesCount: Long,

    /**
     * The application used to post this status.
     */
    @SerialName("application")
    val application: Application? = null,

    /**
     * A link to the status's HTML representation.
     */
    @SerialName("url")
    val url: String? = null,

    /**
     * ID of the status being replied to.
     */
    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    /**
     * ID of the account being replied to.
     */
    @SerialName("in_reply_to_account_id")
    val inReplyToAccountId: String? = null,

    /**
     * The status being boosted.
     */
    @SerialName("reblog")
    val boostedStatus: Status? = null,

    /**
     * The poll attached to the status.
     */
    @SerialName("poll")
    val poll: Poll? = null,

    /**
     * Preview card for links included within status content.
     */
    @SerialName("card")
    val card: Card? = null,

    /**
     * Primary language of this status.
     *
     * ISO 639-1 language two-letter code.
     */
    @SerialName("language")
    val language: String? = null,

    /**
     * Plain-text source of a status.
     *
     * Returned instead of [content] when the status is deleted,
     * so the user may redraft from the source text without the
     * client having to reverse-engineer the original text from
     * the HTML content.
     */
    @SerialName("text")
    val plainText: String? = null,

    /**
     * Whether the current account has favourited this status.
     */
    @SerialName("favourited")
    val isFavourited: Boolean? = null,

    /**
     * Whether the current account has boosted this status.
     */
    @SerialName("reblogged")
    val isBoosted: Boolean? = null,

    /**
     * Whether the current account has muted notifications for this conversation.
     */
    @SerialName("muted")
    val isMuted: Boolean? = null,

    /**
     * Whether the current account has bookmarked this status.
     */
    @SerialName("bookmarked")
    val isBookmarked: Boolean? = null,

    /**
     * Whether the current account has pinned this status.
     *
     * Only appears if the status is pinnable.
     */
    @SerialName("pinned")
    val isPinned: Boolean? = null,
) : Pageable {

    override val id: String
        get() = statusId
}
