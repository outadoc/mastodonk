package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

public interface SuggestionsApi {

    public suspend fun getFollowSuggestions(limit: Int?): List<Account>

    public suspend fun removeSuggestion(id: String)
}
