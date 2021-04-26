package fr.outadoc.mastodonk.api.endpoint.apps

import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.request.apps.TokenCreate
import fr.outadoc.mastodonk.api.entity.request.apps.TokenRevoke

public interface OAuthApi {

    public suspend fun getToken(params: TokenCreate): Token

    public suspend fun revokeToken(params: TokenRevoke)
}
