package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Preferences

public interface PreferencesApi {

    public suspend fun getPreferences(): Preferences
}
