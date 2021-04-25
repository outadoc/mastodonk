package fr.outadoc.mastodonk.api.v1.entity.request.accounts

import fr.outadoc.mastodonk.api.v1.entity.Field
import fr.outadoc.mastodonk.api.v1.entity.request.statuses.SourceCreate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountUpdate(

    @SerialName("discoverable")
    val discoverable: Boolean? = null,

    @SerialName("bot")
    val isBot: Boolean? = null,

    @SerialName("display_name")
    val displayName: String? = null,

    @SerialName("note")
    val note: String? = null,

    @SerialName("avatar")
    val avatar: String? = null,

    @SerialName("header")
    val header: String? = null,

    @SerialName("locked")
    val locked: Boolean? = null,

    @SerialName("fields")
    val fields: List<Field>? = null,

    @SerialName("source")
    val source: SourceCreate? = null
)
