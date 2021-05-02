package fr.outadoc.mastodonk.paging.api.endpoint.notifications

import fr.outadoc.mastodonk.api.endpoint.notifications.NotificationsApi
import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.NotificationType
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun NotificationsApi.getNotificationsSource(
    excludeTypes: List<NotificationType>? = null,
    accountId: String? = null
): PagingSource<PageInfo, Notification>
