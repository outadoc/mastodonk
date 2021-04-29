package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to subscribe to push notifications.
 */
@Serializable
public data class PushSubscribe(

    /**
     * Push subscription settings.
     */
    @SerialName("subscription")
    val subscription: PushSubscription,

    /**
     * Notification alert settings.
     */
    @SerialName("data")
    val data: PushData
)
