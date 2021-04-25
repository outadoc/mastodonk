package fr.outadoc.mastodonk.api.v1.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PartialMarkerProperties(

    @SerialName("last_read_id")
    val lastReadId: String
)
