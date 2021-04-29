package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to submit a new report.
 */
@Serializable
public data class ReportCreate(

    /**
     * ID of the account to report.
     */
    @SerialName("account_id")
    val accountId: String,

    /**
     * ID of statuses to attach to the report, for context.
     */
    @SerialName("status_ids")
    val statusIds: List<String>?,

    /**
     * Reason for the report.
     *
     * Max 1000 characters by default.
     */
    @SerialName("comment")
    val comment: String?,

    /**
     * If the account is remote, should the report be forwarded to the remote admin?
     */
    @SerialName("forward")
    val forwardToRemoteAdmin: Boolean?
)
