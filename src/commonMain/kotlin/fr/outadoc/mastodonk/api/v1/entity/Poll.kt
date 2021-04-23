package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Poll(

    @SerialName("id")
    val id: String,

    @SerialName("expires_at")
    @Serializable(with = InstantSerializer::class)
    val expiresAt: Instant,

    @SerialName("expired")
    val isExpired: Boolean,

    @SerialName("multiple")
    val isMultiple: Boolean,

    @SerialName("votes_count")
    val votesCount: Long,

    @SerialName("voters_count")
    val votersCount: Long,

    @SerialName("voted")
    val hasVoted: Boolean?,

    @SerialName("own_votes")
    val ownVotes: List<Int>?,

    @SerialName("options")
    val options: List<PollOption>,

    @SerialName("emojis")
    val emojis: List<Emoji>
)