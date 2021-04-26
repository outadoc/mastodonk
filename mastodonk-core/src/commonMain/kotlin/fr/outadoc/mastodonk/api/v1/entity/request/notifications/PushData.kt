package fr.outadoc.mastodonk.api.v1.entity.request.notifications

import fr.outadoc.mastodonk.api.v1.entity.Alerts
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PushData(

    @SerialName("alerts")
    val alerts: Alerts
)
