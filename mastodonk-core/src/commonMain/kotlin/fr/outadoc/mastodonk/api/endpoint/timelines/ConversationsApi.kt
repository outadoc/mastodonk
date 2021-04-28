package fr.outadoc.mastodonk.api.endpoint.timelines

import fr.outadoc.mastodonk.api.entity.Conversation
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

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
    public suspend fun getConversations(pageInfo: PageInfo? = null): Page<List<Conversation>>

    /**
     * Deletes a conversation.
     */
    public suspend fun deleteConversation(conversationId: String)

    /**
     * Marks a conversation as read.
     */
    public suspend fun markAsRead(conversationId: String): Conversation
}
