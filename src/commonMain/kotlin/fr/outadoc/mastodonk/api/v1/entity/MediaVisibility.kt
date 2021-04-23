package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MediaVisibility {

    @SerialName("default")
    Default,

    @SerialName("show_all")
    ShowAll,

    @SerialName("hide_all")
    HideAll
}
