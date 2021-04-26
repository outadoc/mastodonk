package fr.outadoc.mastodonk.api.entity.request.admin

import fr.outadoc.mastodonk.api.entity.ActionType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountAction(

    @SerialName("type")
    val type: ActionType? = null,

    @SerialName("report_id")
    val reportId: String? = null,

    @SerialName("warning_preset_id")
    val warningPresetId: String? = null,

    @SerialName("text")
    val text: String?,

    @SerialName("send_email_notification")
    val sendEmailNotification: Boolean? = null
)
