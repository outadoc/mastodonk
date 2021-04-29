package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Related instance URLs.
 */
@Serializable
public data class InstanceUrls(

    /**
     * WebSockets API base URL.
     *
     * e.g. wss://mastodon.example
     */
    @SerialName("streaming_api")
    val streamingApiUrl: String
)
