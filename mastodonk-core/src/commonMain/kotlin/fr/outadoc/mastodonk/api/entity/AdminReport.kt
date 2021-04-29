package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Admin-level information about a filed report.
 */
@Serializable
public data class AdminReport(

    @SerialName("id")
    val reportId: String,

    /**
     * Whether an action was taken to resolve this report.
     */
    @SerialName("action_taken")
    val wasActionTaken: Boolean,

    /**
     * An optional reason for reporting.
     */
    @SerialName("comment")
    val comment: String,

    /**
     * The moment the report was filed.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The time of last action on this report.
     */
    @SerialName("updated_at")
    val updatedAt: Instant,

    /**
     * The account which filed the report.
     */
    @SerialName("account")
    val account: AdminAccount,

    /**
     * The account being reported.
     */
    @SerialName("target_account")
    val targetAccount: AdminAccount,

    /**
     * Statuses attached to the report, for context.
     */
    @SerialName("statuses")
    val statuses: List<Status>,

    /**
     * The account of the moderator assigned to this report.
     */
    @SerialName("assigned_account")
    val assignedAccount: AdminAccount? = null,

    /**
     * The account of the moderator who handled the report.
     */
    @SerialName("action_taken_by_account")
    val actionTakenByAccount: AdminAccount? = null
)
