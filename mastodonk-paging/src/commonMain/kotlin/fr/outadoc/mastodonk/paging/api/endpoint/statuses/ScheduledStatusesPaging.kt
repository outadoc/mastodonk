package fr.outadoc.mastodonk.paging.api.endpoint.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun ScheduledStatusesApi.getScheduledStatusesSource(): PagingSource<PageInfo, ScheduledStatus>
