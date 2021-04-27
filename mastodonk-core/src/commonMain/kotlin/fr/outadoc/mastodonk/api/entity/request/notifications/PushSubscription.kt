package fr.outadoc.mastodonk.api.entity.request.notifications

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PushSubscription(

    /**
     * Endpoint URL that is called when a notification event occurs.
     */
    @SerialName("endpoint")
    val endpoint: String,

    @SerialName("keys")
    val keys: PushKeys
)
