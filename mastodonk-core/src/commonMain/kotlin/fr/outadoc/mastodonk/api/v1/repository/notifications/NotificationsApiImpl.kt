package fr.outadoc.mastodonk.api.v1.repository.notifications

import fr.outadoc.mastodonk.api.v1.endpoint.notifications.NotificationsApi
import fr.outadoc.mastodonk.api.v1.entity.Notification
import fr.outadoc.mastodonk.api.v1.entity.NotificationType
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class NotificationsApiImpl(private val client: MastodonHttpClient) : NotificationsApi {

    override suspend fun getAllNotifications(
        excludeTypes: List<NotificationType>?,
        accountId: String?,
        limit: Int?,
        maxId: String?,
        sinceId: String?,
        minId: String?
    ): List<Notification> {
        return client.request("/api/v1/notifications") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("account_id", accountId)

            excludeTypes?.map { type ->
                Json.Default.encodeToString(type)
            }?.forEach { type ->
                parameter("exclude_types", type)
            }
        }
    }

    override suspend fun getNotification(id: String): Notification {
        return client.request("/api/v1/notifications/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun dismissAllNotifications() {
        return client.request("/api/v1/notifications/clear") {
            method = HttpMethod.Post
        }
    }

    override suspend fun dismissNotification(id: String) {
        return client.request("/api/v1/notifications/${id.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }
}
