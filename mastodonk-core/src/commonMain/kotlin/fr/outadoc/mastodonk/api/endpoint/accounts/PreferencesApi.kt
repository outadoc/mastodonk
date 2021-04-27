package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Preferences

/**
 * View account preferences.
 *
 * @see [preferences - Mastodon Documentation](https://docs.joinmastodon.org/methods/preferences/)
 */
public interface PreferencesApi {

    /**
     * Gets the current account's [Preferences].
     */
    public suspend fun getPreferences(): Preferences
}
