package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PushSubscription(

    @SerialName("id")
    val subscriptionId: String,

    @SerialName("endpoint")
    val endpoint: String,

    @SerialName("server_key")
    val serverKey: String,

    @SerialName("alerts")
    val alerts: Alerts
)
