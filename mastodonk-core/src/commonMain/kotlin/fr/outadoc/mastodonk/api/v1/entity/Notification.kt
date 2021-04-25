package fr.outadoc.mastodonk.api.v1.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Notification(

    @SerialName("id")
    val id: String,

    @SerialName("type")
    val type: NotificationType,

    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,

    @SerialName("account")
    val account: Account,

    @SerialName("status")
    val status: Status? = null
)
