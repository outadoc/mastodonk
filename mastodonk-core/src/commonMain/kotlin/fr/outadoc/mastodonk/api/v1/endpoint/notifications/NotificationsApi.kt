package fr.outadoc.mastodonk.api.v1.endpoint.notifications

import fr.outadoc.mastodonk.api.v1.entity.Notification
import fr.outadoc.mastodonk.api.v1.entity.NotificationType

public interface NotificationsApi {

    public suspend fun getAllNotifications(
        excludeTypes: List<NotificationType>? = null,
        accountId: String? = null,
        limit: Int? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null
    ): List<Notification>

    public suspend fun getNotification(id: String): Notification

    public suspend fun dismissAllNotifications()

    public suspend fun dismissNotification(id: String)
}