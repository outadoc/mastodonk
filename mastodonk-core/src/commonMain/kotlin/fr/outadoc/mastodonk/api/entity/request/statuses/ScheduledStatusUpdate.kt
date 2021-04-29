package fr.outadoc.mastodonk.api.entity.request.statuses

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledStatusUpdate(

    @SerialName("scheduled_at")
    val scheduledAt: Instant?
)
