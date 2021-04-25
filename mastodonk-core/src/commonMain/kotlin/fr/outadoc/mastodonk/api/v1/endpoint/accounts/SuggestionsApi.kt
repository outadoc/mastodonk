package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Account

public interface SuggestionsApi {

    public suspend fun getFollowSuggestions(limit: Int?): List<Account>

    public suspend fun removeSuggestion(id: String)
}
