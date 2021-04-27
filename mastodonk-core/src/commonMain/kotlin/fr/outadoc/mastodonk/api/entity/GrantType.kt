package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class GrantType {

    @SerialName("authorization_code")
    AuthorizationCode,

    @SerialName("client_credentials")
    ClientCredentials
}
