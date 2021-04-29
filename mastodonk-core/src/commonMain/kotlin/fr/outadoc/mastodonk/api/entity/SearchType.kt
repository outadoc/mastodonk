package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SearchType {

    /**
     * Search for accounts.
     */
    @SerialName("accounts")
    Accounts,

    /**
     * Search for hashtags.
     */
    @SerialName("hashtags")
    Hashtags,

    /**
     * Search for statuses.
     */
    @SerialName("statuses")
    Statuses
}
