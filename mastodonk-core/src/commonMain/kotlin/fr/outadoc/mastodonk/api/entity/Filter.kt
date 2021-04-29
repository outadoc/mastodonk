package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Filter(

    @SerialName("id")
    val filterId: String,

    @SerialName("phrase")
    val phrase: String,

    @SerialName("context")
    val context: List<FilterContext>,

    @SerialName("irreversible")
    val isIrreversible: Boolean,

    @SerialName("whole_word")
    val wholeWord: Boolean,

    @SerialName("expires_at")
    val expiresAt: Instant?
)
