package fr.outadoc.mastodonk.api.entity.request.accounts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ReportCreate(

    @SerialName("account_id")
    val accountId: String,

    @SerialName("status_ids")
    val statusIds: List<String>?,

    @SerialName("comment")
    val comment: String?,

    @SerialName("forward")
    val forwardToRemoteAdmin: Boolean?
)
