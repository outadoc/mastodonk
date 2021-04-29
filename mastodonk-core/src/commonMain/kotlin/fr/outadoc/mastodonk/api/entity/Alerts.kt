package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Used to select which alerts to receive from a [PushSubscription].
 */
@Serializable
public data class Alerts(

    /**
     * Receive follow notifications?
     */
    @SerialName("follow")
    val onFollow: Boolean,

    /**
     * Receive favourite notifications?
     */
    @SerialName("favourite")
    val onFavourite: Boolean,

    /**
     * Receive mention notifications?
     */
    @SerialName("mention")
    val onMention: Boolean,

    /**
     * Receive boost notifications?
     */
    @SerialName("reblog")
    val onBoost: Boolean,

    /**
     * Receive poll notifications?
     */
    @SerialName("poll")
    val onPoll: Boolean
)
