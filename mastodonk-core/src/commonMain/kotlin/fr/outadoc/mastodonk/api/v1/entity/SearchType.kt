package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SearchType {

    @SerialName("accounts")
    Accounts,

    @SerialName("hashtags")
    Hashtags,

    @SerialName("statuses")
    Statuses
}
