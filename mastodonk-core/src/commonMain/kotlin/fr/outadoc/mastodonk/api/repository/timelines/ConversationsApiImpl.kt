package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.ConversationsApi
import fr.outadoc.mastodonk.api.entity.Conversation
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class ConversationsApiImpl(private val client: MastodonHttpClient) : ConversationsApi {

    override suspend fun getConversations(limit: Int?, pageInfo: PageInfo?): Page<List<Conversation>> {
        return client.requestPage("/api/v1/conversations") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun deleteConversation(conversationId: String) {
        return client.request("/api/v1/conversations/${conversationId.trim()}") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun markAsRead(conversationId: String): Conversation {
        return client.request("/api/v1/conversations/${conversationId.trim()}/read") {
            method = HttpMethod.Post
        }
    }
}
