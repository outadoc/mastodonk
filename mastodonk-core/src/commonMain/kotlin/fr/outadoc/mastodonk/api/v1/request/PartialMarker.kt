package fr.outadoc.mastodonk.api.v1.request

import fr.outadoc.mastodonk.api.v1.entity.MarkerProperties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PartialMarker(

    @SerialName("home")
    val home: PartialMarkerProperties,

    @SerialName("notifications")
    val notifications: PartialMarkerProperties
)