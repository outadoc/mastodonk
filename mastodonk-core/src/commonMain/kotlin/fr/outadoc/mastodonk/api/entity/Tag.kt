package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a hashtag used within the content of a status.
 */
@Serializable
public data class Tag(

    /**
     * The value of the hashtag after the # sign.
     */
    @SerialName("name")
    val name: String,

    /**
     * URL to the hashtag on the instance.
     */
    @SerialName("url")
    val url: String,

    /**
     * Hashtag usage statistics for given days.
     */
    @SerialName("history")
    val history: List<History>? = null
) : Pageable {

    override val id: String
        get() = name
}
