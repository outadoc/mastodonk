package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Visibility {

    @SerialName("public")
    Public,

    @SerialName("unlisted")
    Unlisted,

    @SerialName("private")
    Private,

    @SerialName("direct")
    Direct
}
