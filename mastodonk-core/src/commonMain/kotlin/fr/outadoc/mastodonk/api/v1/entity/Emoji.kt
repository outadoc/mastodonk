package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Emoji(

    @SerialName("shortcode")
    val shortCode: String,

    @SerialName("url")
    val url: String,

    @SerialName("static_url")
    val staticUrl: String,

    @SerialName("visible_in_picker")
    val isVisibleInPicker: Boolean,

    @SerialName("category")
    val category: String? = null
)