package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountCreate(

    @SerialName("username")
    val username: String,

    @SerialName("email")
    val email: String,

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
