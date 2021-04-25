package fr.outadoc.mastodonk.api.v1.entity.request.statuses

import fr.outadoc.mastodonk.api.v1.entity.Visibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SourceCreate(

    @SerialName("privacy")
    val privacy: Visibility?,

    @SerialName("sensitive")
    val isSensitive: Boolean?,

    @SerialName("language")
    val language: String?
)
