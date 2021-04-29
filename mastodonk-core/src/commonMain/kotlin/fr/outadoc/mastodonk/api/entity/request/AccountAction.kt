package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.ActionType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object to perform an action against an [Account].
 */
@Serializable
public data class AccountAction(

    /**
     * The type of action to be taken.
     */
    @SerialName("type")
    val type: ActionType? = null,

    /**
     * ID of an associated report that caused this action to be taken.
     */
    @SerialName("report_id")
    val reportId: String? = null,

    /**
     * ID of a preset warning.
     */
    @SerialName("warning_preset_id")
    val warningPresetId: String? = null,

    /**
     * Additional text for clarification of why this action was taken.
     */
    @SerialName("text")
    val reason: String?,

    /**
     * Whether an email should be sent to the user with the above information.
     */
    @SerialName("send_email_notification")
    val sendEmailNotification: Boolean? = null
)
