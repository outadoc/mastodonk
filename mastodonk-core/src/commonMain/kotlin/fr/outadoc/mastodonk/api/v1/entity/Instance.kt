package fr.outadoc.mastodonk.api.v1.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Instance(

    @SerialName("uri")
    val uri: String,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("short_description")
    val shortDescription: String,

    @SerialName("email")
    val email: String,

    @SerialName("version")
    val version: String,

    @SerialName("languages")
    val languages: List<String>,

    @SerialName("registrations")
    val areRegistrationsEnabled: Boolean,

    @SerialName("approval_required")
    val isApprovalRequired: Boolean,

    @SerialName("invites_enabled")
    val areInvitesEnabled: Boolean,

    @SerialName("urls")
    val urls: InstanceUrls,

    @SerialName("stats")
    val stats: InstanceStats,

    @SerialName("thumbnail")
    val thumbnail: String? = null,

    @SerialName("contact_account")
    val contactAccount: Account? = null
)
