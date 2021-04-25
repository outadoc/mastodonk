package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.PreferencesApi
import fr.outadoc.mastodonk.api.v1.entity.Preferences
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class PreferencesApiImpl(private val client: MastodonHttpClient) : PreferencesApi {

    override suspend fun getPreferences(): Preferences {
        return client.request("/api/v1/preferences") {
            method = HttpMethod.Get
        }
    }
}
