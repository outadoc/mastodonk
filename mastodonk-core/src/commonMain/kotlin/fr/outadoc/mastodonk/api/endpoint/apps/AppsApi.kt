package fr.outadoc.mastodonk.api.endpoint.apps

import fr.outadoc.mastodonk.api.entity.Application
import fr.outadoc.mastodonk.api.entity.request.ApplicationCreate

/**
 * Register client applications that can be used to obtain OAuth tokens.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/apps/)
 */
public interface AppsApi {

    /**
     * Creates a new application to obtain OAuth2 credentials.
     */
    public suspend fun createApplication(application: ApplicationCreate): Application

    /**
     * Verifies that the app's OAuth2 credentials work.
     */
    public suspend fun verifyCredentials(): Application
}
