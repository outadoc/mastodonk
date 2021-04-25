package fr.outadoc.mastodonk.auth

public data class AuthToken(
    val type: String = "Bearer",
    val accessToken: String
) {
    override fun toString(): String = "$type $accessToken"
}