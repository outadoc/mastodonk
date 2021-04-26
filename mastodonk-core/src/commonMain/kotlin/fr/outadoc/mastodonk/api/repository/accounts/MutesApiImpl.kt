package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.MutesApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class MutesApiImpl(private val client: MastodonHttpClient) : MutesApi {

    override suspend fun getMutes(maxId: String?, limit: Int?, sinceId: String?): List<Account> {
        return client.request("/api/v1/mutes") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
            parameter("since_id", sinceId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
        }
    }
}
