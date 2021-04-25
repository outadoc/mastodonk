package fr.outadoc.mastodonk.api.v1.repository.apps

import fr.outadoc.mastodonk.api.v1.endpoint.apps.OAuthApi
import fr.outadoc.mastodonk.api.v1.entity.Token
import fr.outadoc.mastodonk.api.v1.entity.request.apps.TokenCreate
import fr.outadoc.mastodonk.api.v1.entity.request.apps.TokenRevoke
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class OAuthApiImpl(private val client: MastodonHttpClient) : OAuthApi {

    override suspend fun getToken(params: TokenCreate): Token {
        return client.request("/oauth/token") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = params
        }
    }

    override suspend fun revokeToken(params: TokenRevoke) {
        return client.request("/oauth/revoke") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = params
        }
    }
}