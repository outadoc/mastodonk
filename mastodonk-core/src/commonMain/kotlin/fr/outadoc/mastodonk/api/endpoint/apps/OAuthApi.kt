package fr.outadoc.mastodonk.api.endpoint.apps

import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.request.TokenGet
import fr.outadoc.mastodonk.api.entity.request.TokenRevoke

/**
 * Generate and manage OAuth tokens.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/apps/oauth/)
 */
public interface OAuthApi {

    /**
     * Returns an access token, to be used during API calls that are not public.
     */
    public suspend fun getToken(params: TokenGet): Token

    /**
     * Revoke an access token to make it no longer valid for use.
     */
    public suspend fun revokeToken(params: TokenRevoke)
}
