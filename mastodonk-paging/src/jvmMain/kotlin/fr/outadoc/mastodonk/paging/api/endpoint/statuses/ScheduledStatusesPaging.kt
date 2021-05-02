package fr.outadoc.mastodonk.paging.api.endpoint.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun ScheduledStatusesApi.getScheduledStatusesSource(): PagingSource<PageInfo, ScheduledStatus> {
    return pagingSource { params ->
        getScheduledStatuses(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
