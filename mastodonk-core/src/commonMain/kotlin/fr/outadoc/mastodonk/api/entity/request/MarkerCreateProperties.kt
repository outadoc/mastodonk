package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to save the current position in a timeline.
 */
@Serializable
public data class MarkerCreateProperties(

    /**
     * ID of the last status read in the timeline.
     */
    @SerialName("last_read_id")
    val lastReadId: String
)
