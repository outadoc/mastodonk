package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Visibility of a [Status] to other users.
 */
@Serializable
public enum class StatusVisibility {

    /**
     * Visible to everyone, shown in public timelines.
     */
    @SerialName("public")
    Public,

    /**
     * Visible to public, but not included in public timelines.
     */
    @SerialName("unlisted")
    Unlisted,

    /**
     * Visible to followers only, and to any mentioned users.
     */
    @SerialName("private")
    Private,

    /**
     * Visible only to mentioned users.
     */
    @SerialName("direct")
    Direct
}
