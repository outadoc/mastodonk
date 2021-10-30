package fr.outadoc.mastodonk.api.repository.search

import fr.outadoc.mastodonk.api.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.entity.Results
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.paging.LegacyPageInfo
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class SearchApiImpl(private val client: MastodonHttpClient) : SearchApi {

    override suspend fun search(
        q: String,
        accountId: String?,
        type: SearchType?,
        excludeUnreviewed: Boolean?,
        attemptResolve: Boolean?,
        onlyFollowing: Boolean?,
        limit: Int?,
        pageInfo: LegacyPageInfo?
    ): Results {
        return client.request("/api/v2/search") {
            method = HttpMethod.Get
            parameter("q", q)

            parameter("account_id", accountId)
            type?.let { parameter("type", it.value) }
            parameter("exclude_unreviewed", excludeUnreviewed)
            parameter("resolve", attemptResolve)
            parameter("following", onlyFollowing)
            parameter("limit", limit)
            parameter("offset", pageInfo?.offset)
        }
    }
}
