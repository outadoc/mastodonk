package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Preferences(

    @SerialName("posting:default:visibility")
    val defaultVisibility: Visibility,

    @SerialName("posting:default:sensitive")
    val defaultSensitivity: Boolean,

    @SerialName("posting:default:language")
    val defaultLanguage: String,

    @SerialName("reading:expand:media")
    val defaultMediaVisibility: MediaVisibility,

    @SerialName("reading:expand:spoilers")
    val defaultExpandSpoilers: Boolean
)