package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AdminAccount(

    @SerialName("id")
    val id: String,

    @SerialName("username")
    val username: String,

    @SerialName("domain")
    val domain: String,

    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,

    @SerialName("email")
    val email: String,

    @SerialName("ip")
    val ip: String,

    @SerialName("locale")
    val locale: String,

    @SerialName("invite_request")
    val inviteRequest: String,

    @SerialName("role")
    val role: Role,

    @SerialName("confirmed")
    val isConfirmed: Boolean,

    @SerialName("approved")
    val isApproved: Boolean,

    @SerialName("disabled")
    val isDisabled: Boolean,

    @SerialName("silenced")
    val isSilenced: Boolean,

    @SerialName("suspended")
    val isSuspended: Boolean,

    @SerialName("account")
    val account: Account,

    @SerialName("created_by_application_id")
    val createdByApplicationId: String? = null,

    @SerialName("invited_by_account_id")
    val invitedByAccountId: String? = null
)
