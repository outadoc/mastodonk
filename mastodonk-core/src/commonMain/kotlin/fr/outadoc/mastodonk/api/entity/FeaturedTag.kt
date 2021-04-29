package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class FeaturedTag(

    @SerialName("id")
    val tagId: String,

    @SerialName("name")
    val name: String,

    @SerialName("statuses_count")
    val statusesCount: Long,

    @SerialName("last_status_at")
    val lastStatusAt: LocalDate
)
