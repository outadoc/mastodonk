package fr.outadoc.mastodonk.auth

import fr.outadoc.mastodonk.client.MastodonClient

/**
 * Use this class to provide authentication tokens to the [MastodonClient].
 */
public fun interface AuthTokenProvider {

    /**
     * Provide an authentication token, or null to send unauthenticated requests.
     */
    public fun provideAuthToken(): AuthToken?
}
