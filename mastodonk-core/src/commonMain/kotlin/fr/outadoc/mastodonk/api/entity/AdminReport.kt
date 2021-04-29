package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AdminReport(

    @SerialName("id")
    val reportId: String,

    @SerialName("action_taken")
    val wasActionTaken: Boolean,

    @SerialName("comment")
    val comment: String,

    @SerialName("created_at")
    val createdAt: Instant,

    @SerialName("updated_at")
    val updatedAt: Instant,

    @SerialName("account")
    val account: Account,

    @SerialName("target_account")
    val targetAccount: Account,

    @SerialName("statuses")
    val statuses: List<Status>,

    @SerialName("assigned_account")
    val assignedAccount: Account? = null,

    @SerialName("action_taken_by_account")
    val actionTakenByAccount: Account? = null
)
