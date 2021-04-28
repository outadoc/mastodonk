package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.DomainBlocksApi
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class DomainBlocksApiImpl(private val client: MastodonHttpClient) : DomainBlocksApi {

    override suspend fun getDomainBlocks(pageInfo: PageInfo?): Page<List<String>> {
        return client.requestPage("/api/v1/domain_blocks") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }

    override suspend fun blockDomain(domain: String) {
        return client.request("/api/v1/domain_blocks") {
            method = HttpMethod.Post
            formData {
                append("domain", domain)
            }
        }
    }

    override suspend fun unblockDomain(domain: String) {
        return client.request("/api/v1/domain_blocks") {
            method = HttpMethod.Delete
            formData {
                append("domain", domain)
            }
        }
    }
}
