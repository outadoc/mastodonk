package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Admin-level information about a given account.
 */
@Serializable
public data class AdminAccount(

    @SerialName("id")
    val accountId: String,

    /**
     * The username of the account, not including the domain.
     */
    @SerialName("username")
    val username: String,

    /**
     * The domain of the account.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * Date at which the account was created.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The email address associated with the account.
     */
    @SerialName("email")
    val email: String,

    /**
     * The IP address last used to login to this account.
     */
    @SerialName("ip")
    val ip: String,

    /**
     * The locale of the account.
     */
    @SerialName("locale")
    val locale: String,

    /**
     * Text of the invite request sent to join the server.
     */
    @SerialName("invite_request")
    val inviteRequest: String,

    /**
     * The current role of the account.
     */
    @SerialName("role")
    val role: AccountRole,

    /**
     * Whether the account has confirmed their email address.
     */
    @SerialName("confirmed")
    val isConfirmed: Boolean,

    /**
     * Whether the account is currently approved.
     */
    @SerialName("approved")
    val isApproved: Boolean,

    /**
     * Whether the account is currently disabled.
     */
    @SerialName("disabled")
    val isDisabled: Boolean,

    /**
     * Whether the account is currently silenced.
     */
    @SerialName("silenced")
    val isSilenced: Boolean,

    /**
     * Whether the account is currently suspended.
     */
    @SerialName("suspended")
    val isSuspended: Boolean,

    /**
     * User-level information about the account.
     */
    @SerialName("account")
    val account: Account,

    /**
     * The ID of the application that created this account.
     */
    @SerialName("created_by_application_id")
    val createdByApplicationId: String? = null,

    /**
     * The ID of the account that invited this user.
     */
    @SerialName("invited_by_account_id")
    val invitedByAccountId: String? = null
)
