package fr.outadoc.mastodonk.api.endpoint.notifications

import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.NotificationType

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
