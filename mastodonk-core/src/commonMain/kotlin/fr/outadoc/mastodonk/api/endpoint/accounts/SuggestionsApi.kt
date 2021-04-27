package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

/**
 * View and manage follow suggestions.
 */
public interface SuggestionsApi {

    /**
     * Gets the list of suggested accounts to follow.
     */
    public suspend fun getFollowSuggestions(limit: Int?): List<Account>

    /**
     * Removes an account from the list of suggested accounts to follow.
     */
    public suspend fun removeSuggestion(id: String)
}
