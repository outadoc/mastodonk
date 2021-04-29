package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MarkerCreateProperties(

    /**
     * ID of the last status read in the timeline.
     */
    @SerialName("last_read_id")
    val lastReadId: String
)
