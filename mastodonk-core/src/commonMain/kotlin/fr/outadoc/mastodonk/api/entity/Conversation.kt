package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Conversation(

    @SerialName("id")
    val conversationId: String,

    @SerialName("accounts")
    val accounts: List<Account>,

    @SerialName("unread")
    val isUnread: Boolean,

    @SerialName("last_status")
    val lastStatus: Status? = null
)
