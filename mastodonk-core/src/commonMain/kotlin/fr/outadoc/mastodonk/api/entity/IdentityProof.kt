package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a proof from an external identity provider.
 */
@Serializable
public data class IdentityProof(

    /**
     * The name of the identity provider.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * The account owner's username on the identity provider's service.
     */
    @SerialName("provider_username")
    val providerUsername: String,

    /**
     * When the identity proof was last updated.
     */
    @SerialName("updated_at")
    val updatedAt: Instant,

    /**
     * URL to a statement of identity proof, hosted by the identity provider.
     */
    @SerialName("proof_url")
    val proofUrl: String,

    /**
     * The account owner's profile URL on the identity provider.
     */
    @SerialName("profile_url")
    val profileUrl: String
)
