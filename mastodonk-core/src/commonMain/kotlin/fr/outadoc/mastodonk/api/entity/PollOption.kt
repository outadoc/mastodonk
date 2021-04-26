package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PollOption(

    @SerialName("title")
    val title: String,

    @SerialName("votes_count")
    val votesCount: Long? = null
)
