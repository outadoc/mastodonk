package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object to update push alert settings.
 */
@Serializable
public data class PushUpdate(

    /**
     * Push notification settings.
     */
    @SerialName("data")
    val data: PushData
)
