package fr.outadoc.mastodonk.api.v1.endpoint.apps

import fr.outadoc.mastodonk.api.v1.entity.Token
import fr.outadoc.mastodonk.api.v1.entity.request.apps.TokenCreate
import fr.outadoc.mastodonk.api.v1.entity.request.apps.TokenRevoke

public interface OAuthApi {

    public suspend fun getToken(params: TokenCreate): Token

    public suspend fun revokeToken(params: TokenRevoke)
}
