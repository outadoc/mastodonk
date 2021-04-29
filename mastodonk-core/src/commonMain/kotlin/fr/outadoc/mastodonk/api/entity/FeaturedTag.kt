package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a hashtag that is featured on a profile.
 */
@Serializable
public data class FeaturedTag(

    @SerialName("id")
    val tagId: String,

    /**
     * The name of the hashtag being featured.
     */
    @SerialName("name")
    val name: String,

    /**
     * The number of authored statuses containing this hashtag.
     */
    @SerialName("statuses_count")
    val statusesCount: Long,

    /**
     * The time of the last authored status containing this hashtag.
     */
    @SerialName("last_status_at")
    val lastStatusAt: LocalDate
)
