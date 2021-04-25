package fr.outadoc.mastodonk.api.v1.request

import fr.outadoc.mastodonk.api.v1.entity.Field

public data class PartialAccount(
    val discoverable: Boolean?,
    val bot: Boolean?,
    val displayName: String?,
    val note: String?,
    val avatar: String?,
    val header: String?,
    val locked: Boolean?,
    val fields: List<Field>?,
    val source: PartialSource?
)
