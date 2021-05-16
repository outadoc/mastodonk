package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SearchType(public val value: String) {

    /**
     * Search for accounts.
     */
    @SerialName("accounts")
    Accounts("accounts"),

    /**
     * Search for hashtags.
     */
    @SerialName("hashtags")
    Hashtags("hashtags"),

    /**
     * Search for statuses.
     */
    @SerialName("statuses")
    Statuses("statuses")
}
