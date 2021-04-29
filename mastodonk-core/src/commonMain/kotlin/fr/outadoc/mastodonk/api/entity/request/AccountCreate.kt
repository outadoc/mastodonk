package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.Account
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object to create a new [Account].
 */
@Serializable
public data class AccountCreate(

    /**
     * The desired username for the account.
     */
    @SerialName("username")
    val username: String,

    /**
     * The email address to be used for login.
     */
    @SerialName("email")
    val email: String,

    /**
     * The password to be used for login.
     */
    @SerialName("password")
    val password: String,

    /**
     * Whether the user agrees to the local rules, terms, and policies.
     *
     * These should be presented to the user in order to allow them
     * to consent before setting this parameter to true.
     */
    @SerialName("agreement")
    val agreement: String,

    /**
     * The language of the confirmation email that will be sent.
     */
    @SerialName("locale")
    val locale: String,

    /**
     * Text that will be reviewed by moderators if registrations require manual approval.
     */
    @SerialName("reason")
    val reason: String? = null
)
