package fr.outadoc.mastodonk.api.v1.request

import fr.outadoc.mastodonk.api.v1.entity.PollOption

public data class PartialPoll(
    val options: List<PollOption>,
    val expiresInSec: Long,
    val allowMultipleChoices: Boolean?,
    val hideTotals: Boolean?
)
