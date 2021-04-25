package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.FollowRequestsApi
import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.Relationship
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class FollowRequestsApiImpl(private val client: MastodonHttpClient) : FollowRequestsApi {

    override suspend fun getPendingFollows(limit: String?): List<Account> {
        return client.request("/api/v1/follow_requests") {
            method = HttpMethod.Get
            parameter("limit", limit)
        }
    }

    override suspend fun acceptFollow(id: String): Relationship {
        return client.request("/api/v1/follow_requests/${id.trim()}/authorize") {
            method = HttpMethod.Post
        }
    }

    override suspend fun rejectFollow(id: String): Relationship {
        return client.request("/api/v1/follow_requests/${id.trim()}/reject") {
            method = HttpMethod.Post
        }
    }
}
