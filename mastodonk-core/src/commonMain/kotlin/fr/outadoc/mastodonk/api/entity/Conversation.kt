package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a conversation with "direct message" visibility.
 */
@Serializable
public data class Conversation(

    @SerialName("id")
    val conversationId: String,

    /**
     * Participants in the conversation.
     */
    @SerialName("accounts")
    val participants: List<Account>,

    /**
     * Is the conversation currently marked as unread?
     */
    @SerialName("unread")
    val isUnread: Boolean,

    /**
     * The last status in the conversation, optionally used for display.
     */
    @SerialName("last_status")
    val lastStatus: Status? = null
) : Pageable {

    override val id: String
        get() = conversationId
}
