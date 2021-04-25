package fr.outadoc.mastodonk.api.v1.repository.apps

import fr.outadoc.mastodonk.api.v1.endpoint.apps.AppsApi
import fr.outadoc.mastodonk.api.v1.entity.Application
import fr.outadoc.mastodonk.api.v1.entity.request.apps.ApplicationCreate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class AppsApiImpl(private val client: MastodonHttpClient) : AppsApi {

    override suspend fun createApplication(application: ApplicationCreate): Application {
        return client.request("/api/v1/apps") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = application
        }
    }

    override suspend fun verifyCredentials(): Application {
        return client.request("/api/v1/apps/verify_credentials") {
            method = HttpMethod.Get
        }

    }
}
