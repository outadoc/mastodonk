package fr.outadoc.mastodonk.api.entity.request.accounts

import fr.outadoc.mastodonk.api.entity.FilterContext
import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class FilterUpdate(

    @SerialName("id")
    val id: String,

    @SerialName("phrase")
    val phrase: String,

    @SerialName("context")
    val context: List<FilterContext>,

    @SerialName("irreversible")
    val isIrreversible: Boolean?,

    @SerialName("whole_word")
    val wholeWord: Boolean?,

    @SerialName("expires_in")
    @Serializable(with = InstantSerializer::class)
    val expiresIn: Instant?
)
