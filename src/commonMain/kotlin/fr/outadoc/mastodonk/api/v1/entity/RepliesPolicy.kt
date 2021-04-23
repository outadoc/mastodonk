package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class RepliesPolicy {

    @SerialName("followed")
    Followed,

    @SerialName("list")
    List,

    @SerialName("none")
    None
}
