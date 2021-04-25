package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.MutesApi
import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class MutesApiImpl(private val client: MastodonHttpClient) : MutesApi {

    override suspend fun getMutes(maxId: String?, limit: Int?, minId: String?): List<Status> {
        return client.request("/api/v1/mutes") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
            parameter("min_id", minId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
        }
    }
}