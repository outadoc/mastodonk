package fr.outadoc.mastodonk.api.repository.apps

import fr.outadoc.mastodonk.api.endpoint.apps.OAuthApi
import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.request.TokenGet
import fr.outadoc.mastodonk.api.entity.request.TokenRevoke
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.setBody
import io.ktor.http.*

internal class OAuthApiImpl(private val client: MastodonHttpClient) : OAuthApi {

    override suspend fun getToken(params: TokenGet): Token {
        return client.request("/oauth/token") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(params)
        }
    }

    override suspend fun revokeToken(params: TokenRevoke) {
        return client.request("/oauth/revoke") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(params)
        }
    }
}
