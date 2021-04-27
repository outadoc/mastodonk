package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Status(

    @SerialName("id")
    val statusId: String,

    @SerialName("uri")
    val uri: String,

    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,

    @SerialName("account")
    val account: Account,

    @SerialName("content")
    val content: String,

    @SerialName("visibility")
    val visibility: Visibility,

    @SerialName("sensitive")
    val isSensitive: Boolean,

    @SerialName("spoiler_text")
    val spoilerText: String,

    @SerialName("media_attachments")
    val mediaAttachments: List<Attachment>,

    @SerialName("mentions")
    val mentions: List<Mention>,

    @SerialName("tags")
    val tags: List<Tag>,

    @SerialName("emojis")
    val emojis: List<Emoji>,

    @SerialName("reblogs_count")
    val reblogsCount: Long,

    @SerialName("favourites_count")
    val favouritesCount: Long,

    @SerialName("application")
    val application: Application? = null,

    @SerialName("replies_count")
    val repliesCount: Long? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    @SerialName("in_reply_to_account_id")
    val inReplyToAccountId: String? = null,

    @SerialName("reblog")
    val reblog: Status? = null,

    @SerialName("poll")
    val poll: Poll? = null,

    @SerialName("card")
    val card: Card? = null,

    @SerialName("language")
    val language: String? = null,

    @SerialName("text")
    val text: String? = null
)
