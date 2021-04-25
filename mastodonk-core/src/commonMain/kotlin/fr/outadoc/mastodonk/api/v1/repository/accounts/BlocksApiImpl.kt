package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.BlocksApi
import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class BlocksApiImpl(private val client: MastodonHttpClient) : BlocksApi {

    override suspend fun getBlocks(maxId: String?, limit: Int?, sinceId: String?): List<Account> {
        return client.request("/api/v1/blocks") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
            parameter("since_id", sinceId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
        }
    }
}