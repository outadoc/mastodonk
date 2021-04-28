package fr.outadoc.mastodonk.api.repository.notifications

import fr.outadoc.mastodonk.api.endpoint.notifications.NotificationsApi
import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.NotificationType
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class NotificationsApiImpl(private val client: MastodonHttpClient) : NotificationsApi {

    override suspend fun getNotifications(
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

    override suspend fun getNotification(notificationId: String): Notification? {
        return client.requestOrNull("/api/v1/notifications/${notificationId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun dismissAllNotifications() {
        return client.request("/api/v1/notifications/clear") {
            method = HttpMethod.Post
        }
    }

    override suspend fun dismissNotification(notificationId: String) {
        return client.request("/api/v1/notifications/${notificationId.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }
}
