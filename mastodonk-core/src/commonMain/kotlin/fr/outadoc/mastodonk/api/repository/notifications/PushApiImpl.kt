package fr.outadoc.mastodonk.api.repository.notifications

import fr.outadoc.mastodonk.api.endpoint.notifications.PushApi
import fr.outadoc.mastodonk.api.entity.PushSubscription
import fr.outadoc.mastodonk.api.entity.request.PushSubscribe
import fr.outadoc.mastodonk.api.entity.request.PushUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class PushApiImpl(private val client: MastodonHttpClient) : PushApi {

    override suspend fun subscribe(params: PushSubscribe): PushSubscription {
        return client.request("/api/v1/push/subscription") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = params
        }
    }

    override suspend fun getSubscription(): PushSubscription {
        return client.request("/api/v1/push/subscription") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateSubscription(params: PushUpdate): PushSubscription {
        return client.request("/api/v1/push/subscription") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            body = params
        }
    }

    override suspend fun deleteSubscription() {
        return client.request("/api/v1/push/subscription") {
            method = HttpMethod.Delete
        }
    }
}
