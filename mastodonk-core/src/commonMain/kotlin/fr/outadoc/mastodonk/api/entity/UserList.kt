package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class UserList(

    @SerialName("id")
    val listId: String,

    @SerialName("title")
    val title: String,

    @SerialName("replies_policy")
    val repliesPolicy: RepliesPolicy
)
