package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Marks the user's current position in their timelines,
 * to synchronize and restore it across devices.
 */
@Serializable
public data class Marker(

    /**
     * Home timeline marker.
     */
    @SerialName("home")
    val home: MarkerProperties,

    /**
     * Notifications timeline marker.
     */
    @SerialName("notifications")
    val notifications: MarkerProperties
)
