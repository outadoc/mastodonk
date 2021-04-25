package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Marker(

    @SerialName("home")
    val home: MarkerProperties,

    @SerialName("notifications")
    val notifications: MarkerProperties
)
