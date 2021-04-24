package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Field(

    @SerialName("name")
    val name: String,

    @SerialName("value")
    val value: String,

    @SerialName("verified_at")
    @Serializable(with = InstantSerializer::class)
    val verifiedAt: Instant?
)