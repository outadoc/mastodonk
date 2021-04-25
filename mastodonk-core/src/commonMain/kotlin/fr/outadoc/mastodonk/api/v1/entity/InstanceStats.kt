package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class InstanceStats(

    @SerialName("user_count")
    val userCount: Long,

    @SerialName("status_count")
    val statusCount: Long,

    @SerialName("domain_count")
    val domainCount: Long,
)
