package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Error(

    @SerialName("error")
    val error: String,

    @SerialName("error_description")
    val errorDescription: String? = null
)
