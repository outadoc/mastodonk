package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Alerts(

    @SerialName("follow")
    val onFollow: Boolean,

    @SerialName("favourite")
    val onFavourite: Boolean,

    @SerialName("mention")
    val onMention: Boolean,

    @SerialName("reblog")
    val onBoost: Boolean,

    @SerialName("poll")
    val onPoll: Boolean
)
