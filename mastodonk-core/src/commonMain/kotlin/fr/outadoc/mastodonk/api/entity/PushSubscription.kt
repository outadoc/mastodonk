package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a subscription to the push streaming server.
 */
@Serializable
public data class PushSubscription(

    @SerialName("id")
    val subscriptionId: String,

    /**
     * URL where push alerts will be sent to.
     */
    @SerialName("endpoint")
    val endpoint: String,

    /**
     * The streaming server's VAPID key.
     */
    @SerialName("server_key")
    val serverKey: String,

    /**
     * Which alerts should be delivered to the endpoint.
     */
    @SerialName("alerts")
    val alerts: Alerts
)
