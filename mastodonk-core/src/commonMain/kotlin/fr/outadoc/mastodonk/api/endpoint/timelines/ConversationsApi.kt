package fr.outadoc.mastodonk.api.endpoint.timelines

import fr.outadoc.mastodonk.api.entity.Conversation

/**
 * Direct conversations with other participants.
 *
 * Currently, just threads containing a post with "direct" visibility.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/timelines/conversations/)
 */
public interface ConversationsApi {

    /**
     * Gets the list of conversations for the current account.
     */
    public suspend fun getConversations(
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null
    ): List<Conversation>

    /**
     * Deletes a conversation.
     */
    public suspend fun deleteConversation(conversationId: String)

    /**
     * Marks a conversation as read.
     */
    public suspend fun markAsRead(conversationId: String): Conversation
}
