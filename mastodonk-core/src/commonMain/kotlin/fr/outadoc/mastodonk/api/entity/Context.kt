package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the tree around a given status.
 *
 * Used for reconstructing threads of statuses.
 */
@Serializable
public data class Context(

    /**
     * Parent statuses in the thread.
     */
    @SerialName("ancestors")
    val ancestors: List<Status>,

    /**
     * Children statuses in the thread.
     */
    @SerialName("descendants")
    val descendants: List<Status>
)
