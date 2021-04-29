package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Alerts
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PushData(

    @SerialName("alerts")
    val alerts: Alerts
)
