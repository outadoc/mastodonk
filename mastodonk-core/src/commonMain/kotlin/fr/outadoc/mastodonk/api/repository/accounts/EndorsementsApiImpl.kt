package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.EndorsementsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class EndorsementsApiImpl(private val client: MastodonHttpClient) : EndorsementsApi {

    override suspend fun getFeaturedAccounts(limit: Int?, pageInfo: PageInfo?): Page<List<Account>> {
        return client.requestPage("/api/v1/endorsements") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }
}
