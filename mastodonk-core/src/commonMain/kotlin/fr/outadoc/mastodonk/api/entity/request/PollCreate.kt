package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Poll
import fr.outadoc.mastodonk.api.entity.PollOption
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to create a new [Poll].
 */
@Serializable
public data class PollCreate(

    /**
     * Array of possible answers.
     */
    @SerialName("options")
    val options: List<PollOption>,

    /**
     * Duration the poll should be open, in seconds.
     */
    @SerialName("expires_in")
    val expiresInSec: Long,

    /**
     * Allow multiple choices in the poll?
     */
    @SerialName("allow_multiple_choices")
    val allowMultipleChoices: Boolean?,

    /**
     * Hide vote counts until the poll ends?
     */
    @SerialName("hide_totals")
    val hideTotals: Boolean?
)
