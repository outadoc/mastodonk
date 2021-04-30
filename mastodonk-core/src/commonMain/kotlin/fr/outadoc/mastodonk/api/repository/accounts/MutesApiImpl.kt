package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.MutesApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class MutesApiImpl(private val client: MastodonHttpClient) : MutesApi {

    override suspend fun getMutes(limit: Int?, pageInfo: PageInfo?): Page<List<Account>> {
        return client.requestPage("/api/v1/mutes") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }
}
