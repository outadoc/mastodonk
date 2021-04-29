package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToLocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a weekly bucket of instance activity.
 */
@Serializable
public data class Activity(

    /**
     * First day of the week corresponding to this activity.
     */
    @SerialName("week")
    @Serializable(with = TimestampToLocalDateSerializer::class)
    val week: LocalDate,

    /**
     * Number of statuses posted during the week.
     */
    @SerialName("statuses")
    val statusCount: Long,

    /**
     * Number of logins during the week.
     */
    @SerialName("logins")
    val loginCount: Long,

    /**
     * Number of users that registered during the week.
     */
    @SerialName("registrations")
    val registrationCount: Long
)
