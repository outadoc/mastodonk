package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class UserList(

    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("replies_policy")
    val repliesPolicy: RepliesPolicy
)
