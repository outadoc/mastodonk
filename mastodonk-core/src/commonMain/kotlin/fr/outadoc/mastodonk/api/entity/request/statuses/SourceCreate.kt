package fr.outadoc.mastodonk.api.entity.request.statuses

import fr.outadoc.mastodonk.api.entity.Visibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SourceCreate(

    /**
     * Default post privacy for authored statuses.
     */
    @SerialName("privacy")
    val privacy: Visibility?,

    /**
     * Whether to mark authored statuses as sensitive by default.
     */
    @SerialName("sensitive")
    val isSensitive: Boolean?,

    /**
     * Default language to use for authored statuses. (ISO 6391)
     */
    @SerialName("language")
    val language: String?
)
