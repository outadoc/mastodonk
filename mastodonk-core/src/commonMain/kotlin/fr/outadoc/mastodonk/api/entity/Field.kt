package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Profile metadata name and value.
 *
 * By default, max 4 fields and 255 characters per property/value.
 */
@Serializable
public data class Field(

    @SerialName("name")
    val name: String,

    @SerialName("value")
    val value: String,

    @SerialName("verified_at")
    @Serializable(with = InstantSerializer::class)
    val verifiedAt: Instant? = null
)
