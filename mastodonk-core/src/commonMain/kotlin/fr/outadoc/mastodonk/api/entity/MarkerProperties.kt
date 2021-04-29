package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MarkerProperties(

    @SerialName("last_read_id")
    val lastReadId: String,

    @SerialName("updated_at")
    val updatedAt: Instant,

    @SerialName("version")
    val version: Long
)
