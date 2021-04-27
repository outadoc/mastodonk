package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Report(

    @SerialName("id")
    val id: String,

    @SerialName("action_taken")
    val wasActionTaken: Boolean
)