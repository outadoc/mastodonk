package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Activity(

    @SerialName("week")
    @Serializable(with = LocalDateSerializer::class)
    val week: LocalDate,

    @SerialName("statuses")
    val statusCount: Long,

    @SerialName("logins")
    val loginCount: Long,

    @SerialName("registrations")
    val registrationCount: Long
)