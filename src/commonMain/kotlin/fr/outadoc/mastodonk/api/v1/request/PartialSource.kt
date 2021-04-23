package fr.outadoc.mastodonk.api.v1.request

import fr.outadoc.mastodonk.api.v1.entity.Visibility

public data class PartialSource(
    val privacy: Visibility?,
    val sensitive: Boolean?,
    val language: String?
)
