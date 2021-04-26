package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class CardType {

    @SerialName("link")
    Link,

    @SerialName("photo")
    Photo,

    @SerialName("video")
    Video,

    @SerialName("rich")
    Rich
}
