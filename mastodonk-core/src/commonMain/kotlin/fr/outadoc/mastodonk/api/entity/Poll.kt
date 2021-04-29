package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Poll(

    @SerialName("id")
    val pollId: String,

    @SerialName("expired")
    val isExpired: Boolean,

    @SerialName("multiple")
    val isMultiple: Boolean,

    @SerialName("votes_count")
    val votesCount: Long,

    @SerialName("options")
    val options: List<PollOption>,

    @SerialName("emojis")
    val emojis: List<Emoji>,

    @SerialName("expires_at")
    val expiresAt: Instant? = null,

    @SerialName("voters_count")
    val votersCount: Long? = null,

    @SerialName("voted")
    val hasVoted: Boolean? = null,

    @SerialName("own_votes")
    val ownVotes: List<Int>? = null
)
