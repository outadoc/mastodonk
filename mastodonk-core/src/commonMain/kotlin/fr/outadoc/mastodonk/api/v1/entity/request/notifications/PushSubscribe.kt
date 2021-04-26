package fr.outadoc.mastodonk.api.v1.entity.request.notifications

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PushSubscribe(

    @SerialName("subscription")
    val subscription: PushSubscription,

    @SerialName("data")
    val data: PushData
)
