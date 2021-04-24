package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Source(

    @SerialName("note")
    val note: String,

    @SerialName("fields")
    val fields: List<Field>,

    @SerialName("privacy")
    val privacy: Visibility? = null,

    @SerialName("sensitive")
    val isSensitive: Boolean? = null,

    @SerialName("language")
    val language: String? = null,

    @SerialName("follow_requests_count")
    val followRequestsCount: Long? = null
)