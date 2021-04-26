package fr.outadoc.mastodonk.api.entity.request.statuses

import fr.outadoc.mastodonk.api.entity.PollOption
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PollCreate(

    @SerialName("options")
    val options: List<PollOption>,

    @SerialName("expires_in")
    val expiresInSec: Long,

    @SerialName("allow_multiple_choices")
    val allowMultipleChoices: Boolean?,

    @SerialName("hide_totals")
    val hideTotals: Boolean?
)