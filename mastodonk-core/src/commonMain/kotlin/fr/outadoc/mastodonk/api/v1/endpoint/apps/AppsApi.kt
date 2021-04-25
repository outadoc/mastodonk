package fr.outadoc.mastodonk.api.v1.endpoint.apps

import fr.outadoc.mastodonk.api.v1.entity.Application
import fr.outadoc.mastodonk.api.v1.entity.request.apps.ApplicationCreate

public interface AppsApi {

    public suspend fun createApplication(application: ApplicationCreate): Application

    public suspend fun verifyCredentials(): Application
}
