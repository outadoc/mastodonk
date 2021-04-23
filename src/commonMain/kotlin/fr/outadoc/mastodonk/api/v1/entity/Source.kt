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
    val privacy: Visibility?,

    @SerialName("sensitive")
    val isSensitive: Boolean?,

    @SerialName("language")
    val language: String?,

    @SerialName("follow_requests_count")
    val followRequestsCount: Long?
)