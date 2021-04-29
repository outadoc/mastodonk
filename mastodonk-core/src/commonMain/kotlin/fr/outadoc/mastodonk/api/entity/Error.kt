package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an API error.
 */
@Serializable
public data class Error(

    /**
     * The error message.
     */
    @SerialName("error")
    val error: String,

    /**
     * A longer description of the error.
     */
    @SerialName("error_description")
    val errorDescription: String? = null
)
