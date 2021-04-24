package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Context(

    @SerialName("ancestors")
    val ancestors: List<Status>,

    @SerialName("descendants")
    val descendants: List<Status>
)