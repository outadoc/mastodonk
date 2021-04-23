package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Conversation(

    @SerialName("id")
    val id: String,

    @SerialName("accounts")
    val accounts: List<Account>,

    @SerialName("unread")
    val isUnread: Boolean,

    @SerialName("last_status")
    val lastStatus: Status?
)