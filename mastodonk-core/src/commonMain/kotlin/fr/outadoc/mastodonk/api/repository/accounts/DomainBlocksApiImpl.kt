package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.DomainBlocksApi
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class DomainBlocksApiImpl(private val client: MastodonHttpClient) : DomainBlocksApi {

    override suspend fun getDomainBlocks(maxId: String?, limit: Int?, sinceId: String?): List<String> {
        return client.request("/api/v1/domain_blocks") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
            parameter("since_id", sinceId) // FIXME Internal parameter. Use the HTTP Link header for pagination instead.
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
