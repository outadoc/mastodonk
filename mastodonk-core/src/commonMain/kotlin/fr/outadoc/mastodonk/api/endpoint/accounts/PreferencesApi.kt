package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Preferences

/**
 * View account preferences.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/preferences/)
 */
public interface PreferencesApi {

    /**
     * Gets the current account's [Preferences].
     */
    public suspend fun getPreferences(): Preferences
}
