package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.BlocksApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class BlocksApiImpl(private val client: MastodonHttpClient) : BlocksApi {

    override suspend fun getBlocks(pageInfo: PageInfo?): Page<List<Account>> {
        return client.requestPage("/api/v1/blocks") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }
}
