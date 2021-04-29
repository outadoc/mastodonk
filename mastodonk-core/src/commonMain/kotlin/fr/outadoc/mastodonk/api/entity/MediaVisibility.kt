package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Preferred media content visibility, i.e. whether media attachments
 * should be automatically displayed or blurred/hidden.
 */
@Serializable
public enum class MediaVisibility {

    /**
     * Hide media marked as sensitive.
     */
    @SerialName("default")
    Default,

    /**
     * Always show all media by default, regardless of sensitivity.
     */
    @SerialName("show_all")
    ShowAll,

    /**
     * Always hide all media by default, regardless of sensitivity.
     */
    @SerialName("hide_all")
    HideAll
}
