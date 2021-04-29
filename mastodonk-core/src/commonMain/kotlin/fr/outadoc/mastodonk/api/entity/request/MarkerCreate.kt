package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Marker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to create a new [Marker].
 */
@Serializable
public data class MarkerCreate(

    /**
     * Marker for the home timeline.
     */
    @SerialName("home")
    val home: MarkerCreateProperties,

    /**
     * Marker for the notifications timeline.
     */
    @SerialName("notifications")
    val notifications: MarkerCreateProperties
)
