package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.ConversationsApi
import fr.outadoc.mastodonk.api.entity.Conversation
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class ConversationsApiImpl(private val client: MastodonHttpClient) : ConversationsApi {

    override suspend fun getConversations(
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Conversation> {
        return client.request("/api/v1/conversations") {
            method = HttpMethod.Get
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("limit", limit)
        }
    }

    override suspend fun deleteConversation(id: String) {
        return client.request("/api/v1/conversations/${id.trim()}") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun markAsRead(id: String): Conversation {
        return client.request("/api/v1/conversations/${id.trim()}/read") {
            method = HttpMethod.Post
        }
    }
}
