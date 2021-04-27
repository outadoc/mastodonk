package fr.outadoc.mastodonk.api.entity.request.accounts

import fr.outadoc.mastodonk.api.entity.Field
import fr.outadoc.mastodonk.api.entity.request.statuses.SourceCreate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountUpdate(

    /**
     * Whether the account should be shown in the profile directory.
     */
    @SerialName("discoverable")
    val discoverable: Boolean? = null,

    @SerialName("bot")
    val isBot: Boolean? = null,

    @SerialName("display_name")
    val displayName: String? = null,

    /**
     * The account bio.
     */
    @SerialName("note")
    val note: String? = null,

    /**
     * Avatar image encoded using multipart/form-data.
     */
    @SerialName("avatar")
    val avatar: String? = null,

    /**
     * Header image encoded using multipart/form-data.
     */
    @SerialName("header")
    val header: String? = null,

    /**
     * Whether manual approval of follow requests is required.
     */
    @SerialName("locked")
    val locked: Boolean? = null,

    /**
     * Profile metadata name and value.
     *
     * By default, max 4 fields and 255 characters per property/value.
     */
    @SerialName("fields_attributes")
    val fields: List<Field>? = null,

    @SerialName("source")
    val source: SourceCreate? = null
)
