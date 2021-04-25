package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.SuggestionsApi
import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class SuggestionsApiImpl(private val client: MastodonHttpClient) : SuggestionsApi {

    override suspend fun getFollowSuggestions(limit: Int?): List<Account> {
        return client.request("/api/v1/suggestions") {
            method = HttpMethod.Get
            parameter("limit", limit)
        }
    }

    override suspend fun removeSuggestion(id: String) {
        return client.request("/api/v1/suggestions/${id.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
