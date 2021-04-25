package fr.outadoc.mastodonk.api.v1.entity.request.timelines

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MarkerCreateProperties(

    @SerialName("last_read_id")
    val lastReadId: String
)
