package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class IdentityProof(

    @SerialName("provider")
    val provider: String,

    @SerialName("provider_username")
    val providerUsername: String,

    @SerialName("updated_at")
    val updatedAt: Instant,

    @SerialName("proof_url")
    val proofUrl: String,

    @SerialName("profile_url")
    val profileUrl: String
)
