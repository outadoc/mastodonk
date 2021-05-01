package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.createPagingSource

public fun TimelinesApi.getPublicTimelineSource(
    onlyLocal: Boolean? = null,
    onlyRemote: Boolean? = null,
    onlyMedia: Boolean? = null
): PagingSource<PageInfo, Status> {
    return createPagingSource { params ->
        getPublicTimeline(
            onlyLocal = onlyLocal,
            onlyRemote = onlyRemote,
            onlyMedia = onlyMedia,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
