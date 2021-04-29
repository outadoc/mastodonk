package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Usage statistics about the Mastodon instance.
 */
@Serializable
public data class InstanceStats(

    /**
     * Number of users registered on this instance.
     */
    @SerialName("user_count")
    val userCount: Long,

    /**
     * Number of statuses posted on this instance.
     */
    @SerialName("status_count")
    val statusCount: Long,

    /**
     * Number of domains federated with this instance.
     */
    @SerialName("domain_count")
    val domainCount: Long,
)
