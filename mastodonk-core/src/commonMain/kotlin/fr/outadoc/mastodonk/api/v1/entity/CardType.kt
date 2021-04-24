package fr.outadoc.mastodonk.api.v1.entity

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