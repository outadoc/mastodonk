package fr.outadoc.mastodonk.api.endpoint.apps

import fr.outadoc.mastodonk.api.entity.Application
import fr.outadoc.mastodonk.api.entity.request.apps.ApplicationCreate

public interface AppsApi {

    public suspend fun createApplication(application: ApplicationCreate): Application

    public suspend fun verifyCredentials(): Application
}
