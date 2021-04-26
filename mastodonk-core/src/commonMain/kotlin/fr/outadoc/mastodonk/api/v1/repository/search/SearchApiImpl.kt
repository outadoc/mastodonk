package fr.outadoc.mastodonk.api.v1.repository.search

import fr.outadoc.mastodonk.api.v1.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.v1.entity.Results
import fr.outadoc.mastodonk.api.v1.entity.SearchType
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class SearchApiImpl(private val client: MastodonHttpClient) : SearchApi {

    override suspend fun search(
        q: String,
        accountId: String?,
        type: SearchType?,
        excludeUnreviewed: Boolean?,
        attemptResolve: Boolean?,
        maxId: String?,
        minId: String?,
        limit: Int?,
        offset: Int?
    ): Results {
        return client.request("/api/v2/search") {
            method = HttpMethod.Get
            parameter("q", q)

            parameter("account_id", accountId)
            type?.let { parameter("type", Json.Default.encodeToString(it)) }
            parameter("exclude_unreviewed", excludeUnreviewed)
            parameter("resolve", attemptResolve)

            parameter("max_id", maxId)
            parameter("min_id", minId)
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }
}