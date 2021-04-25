package fr.outadoc.mastodonk.api.v1.entity.request.statuses

import fr.outadoc.mastodonk.api.v1.entity.PollOption
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PartialPoll(

    @SerialName("options")
    val options: List<PollOption>,

    @SerialName("expires_in")
    val expiresInSec: Long,

    @SerialName("allow_multiple_choices")
    val allowMultipleChoices: Boolean?,

    @SerialName("hide_totals")
    val hideTotals: Boolean?
)
