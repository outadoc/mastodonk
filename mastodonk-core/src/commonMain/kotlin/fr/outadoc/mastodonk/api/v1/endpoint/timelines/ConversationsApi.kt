package fr.outadoc.mastodonk.api.v1.endpoint.timelines

import fr.outadoc.mastodonk.api.v1.entity.Conversation
import fr.outadoc.mastodonk.client.MastodonEndpoint

public interface ConversationsApi : MastodonEndpoint {

    public suspend fun getConversation(
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null
    ): List<Conversation>

    public suspend fun deleteConversation(id: String)

    public suspend fun markAsRead(id: String): Conversation
}
