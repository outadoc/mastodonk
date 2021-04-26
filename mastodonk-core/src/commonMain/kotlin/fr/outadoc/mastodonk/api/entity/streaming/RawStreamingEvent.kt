package fr.outadoc.mastodonk.api.entity.streaming

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RawStreamingEvent(

    @SerialName("event")
    val event: String,

    @SerialName("payload")
    val payload: String? = null
)
