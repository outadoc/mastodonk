package fr.outadoc.mastodonk.api.endpoint.notifications

import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.NotificationType

/**
 * Receive notifications for activity on the account or statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/notifications/)
 */
public interface NotificationsApi {

    /**
     * Gets notifications concerning the account.
     *
     * @param excludeTypes Types to exclude from the results.
     */
    public suspend fun getNotifications(
        excludeTypes: List<NotificationType>? = null,
        accountId: String? = null,
        limit: Int? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null
    ): List<Notification>

    /**
     * Gets information about a notification.
     */
    public suspend fun getNotification(notificationId: String): Notification

    /**
     * Clears all notifications for the account.
     */
    public suspend fun dismissAllNotifications()

    /**
     * Clears a single notification.
     */
    public suspend fun dismissNotification(notificationId: String)
}
