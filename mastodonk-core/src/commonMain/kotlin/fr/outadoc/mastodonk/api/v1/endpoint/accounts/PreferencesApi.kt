package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Preferences

public interface PreferencesApi {

    public suspend fun getPreferences(): Preferences
}
