package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Status(

    @SerialName("id")
    val id: String,

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

    @SerialName("spoiler_text")
    val spoilerText: String,

    @SerialName("media_attachments")
    val mediaAttachments: List<Attachment>,

    @SerialName("application")
    val application: Application,

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

    @SerialName("replies_count")
    val repliesCount: Long?,

    @SerialName("url")
    val url: String?,

    @SerialName("in_reply_to_id")
    val inReplyToId: String?,

    @SerialName("in_reply_to_account_id")
    val inReplyToAccountId: String?,

    @SerialName("reblog")
    val reblog: Status?,

    @SerialName("poll")
    val poll: Poll?,

    @SerialName("card")
    val card: Card?,

    @SerialName("language")
    val language: String?,

    @SerialName("text")
    val text: String?
)