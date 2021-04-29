package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MarkerCreate(

    @SerialName("home")
    val home: MarkerCreateProperties,

    @SerialName("notifications")
    val notifications: MarkerCreateProperties
)
