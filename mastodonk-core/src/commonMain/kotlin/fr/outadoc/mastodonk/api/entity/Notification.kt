package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Notification(

    @SerialName("id")
    val notificationId: String,

    @SerialName("type")
    val type: NotificationType,

    @SerialName("created_at")
    val createdAt: Instant,

    @SerialName("account")
    val account: Account,

    @SerialName("status")
    val status: Status? = null
)
