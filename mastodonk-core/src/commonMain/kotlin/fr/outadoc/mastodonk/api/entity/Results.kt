package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Results(

    @SerialName("accounts")
    val accounts: List<Account>,

    @SerialName("statuses")
    val statuses: List<Status>,

    @SerialName("hashtags")
    val hashtags: List<Tag>
)
