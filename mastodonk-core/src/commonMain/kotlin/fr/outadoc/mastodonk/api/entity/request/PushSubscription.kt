package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Push subscription
 */
@Serializable
public data class PushSubscription(

    /**
     * Endpoint URL that is called when a notification event occurs.
     */
    @SerialName("endpoint")
    val endpoint: String,

    /**
     * Push server keys.
     */
    @SerialName("keys")
    val keys: PushKeys
)
