package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Filter
import fr.outadoc.mastodonk.api.entity.FilterContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object used to create a new [Filter].
 */
@Serializable
public data class FilterCreate(

    /**
     * Text to be filtered.
     */
    @SerialName("phrase")
    val phrase: String,

    /**
     * Contexts to filter in. At least one context must be specified.
     */
    @SerialName("context")
    val context: List<FilterContext>,

    /**
     * Should the server irreversibly drop matching entities from home and notifications?
     */
    @SerialName("irreversible")
    val isIrreversible: Boolean?,

    /**
     * Consider word boundaries?
     */
    @SerialName("whole_word")
    val wholeWord: Boolean?,

    /**
     * Number of seconds from now the filter should expire.
     *
     * If null, will never expire.
     */
    @SerialName("expires_in")
    val expiresInSec: Long?
)
