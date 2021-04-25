package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.EndorsementsApi
import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class EndorsementsApiImpl(private val client: MastodonHttpClient) : EndorsementsApi {

    override suspend fun getEndorsements(limit: Int?, maxId: String?, sinceId: String?): List<Account> {
        return client.request("/api/v1/endorsements") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
            parameter("since_id", sinceId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
        }
    }
}
