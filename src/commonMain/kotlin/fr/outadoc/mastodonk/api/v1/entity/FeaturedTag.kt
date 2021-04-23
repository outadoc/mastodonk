package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class FeaturedTag(

    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String,

    @SerialName("statuses_count")
    val statusesCount: Long,

    @SerialName("last_status_at")
    @Serializable(with = InstantSerializer::class)
    val lastStatusAt: Instant
)