package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class InstanceUrls(

    @SerialName("streaming_api")
    val streamingApi: String? = null
)
