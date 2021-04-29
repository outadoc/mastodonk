package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a notification of an event relevant to the user.
 */
@Serializable
public data class Notification(

    @SerialName("id")
    val notificationId: String,

    /**
     * The type of event that resulted in the notification.
     */
    @SerialName("type")
    val type: NotificationType,

    /**
     * The time of this notification.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The account that performed the action that generated the notification.
     */
    @SerialName("account")
    val account: Account,

    /**
     * Status that was the object of the notification, if relevant.
     */
    @SerialName("status")
    val status: Status? = null
)
