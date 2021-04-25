package fr.outadoc.mastodonk.api.v1.repository.instance

import fr.outadoc.mastodonk.api.v1.endpoint.instance.InstanceApi
import fr.outadoc.mastodonk.api.v1.entity.Activity
import fr.outadoc.mastodonk.api.v1.entity.Instance
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class InstanceApiImpl(private val client: MastodonHttpClient) : InstanceApi {

    override suspend fun getInstance(): Instance {
        return client.request("/api/v1/instance") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getPeers(): List<String> {
        return client.request("/api/v1/instance/peers") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getActivity(): List<Activity> {
        return client.request("/api/v1/instance/activity") {
            method = HttpMethod.Get
        }
    }
}
