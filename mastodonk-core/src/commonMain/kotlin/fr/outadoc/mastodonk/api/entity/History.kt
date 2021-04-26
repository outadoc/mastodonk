package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToLocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class History(

    @SerialName("day")
    @Serializable(with = TimestampToLocalDateSerializer::class)
    val day: LocalDate,

    @SerialName("uses")
    val uses: String? = null,

    @SerialName("account")
    val accounts: String
)
