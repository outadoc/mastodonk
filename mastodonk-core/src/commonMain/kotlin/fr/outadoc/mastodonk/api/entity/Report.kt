package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Reports filed against users and/or statuses, to be taken action on by moderators.
 */
@Serializable
public data class Report(

    @SerialName("id")
    val reportId: String,

    /**
     * Whether an action was taken to resolve this report.
     */
    @SerialName("action_taken")
    val wasActionTaken: Boolean
)
