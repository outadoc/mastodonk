package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class History(

    @SerialName("day")
    @Serializable(with = LocalDateSerializer::class)
    val day: LocalDate,

    @SerialName("uses")
    val uses: String?,

    @SerialName("account")
    val accounts: String
)