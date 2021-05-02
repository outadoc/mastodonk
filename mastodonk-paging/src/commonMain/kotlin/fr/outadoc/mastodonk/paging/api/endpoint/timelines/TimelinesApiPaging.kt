package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource

public expect fun TimelinesApi.getPublicTimelineSource(
    onlyLocal: Boolean? = null,
    onlyRemote: Boolean? = null,
    onlyMedia: Boolean? = null
): PagingSource<PageInfo, Status>

public expect fun TimelinesApi.getHashtagTimelineSource(
    hashtag: String,
    onlyLocal: Boolean? = null,
    onlyMedia: Boolean? = null
): PagingSource<PageInfo, Status>

public expect fun TimelinesApi.getHomeTimelineSource(onlyLocal: Boolean? = null): PagingSource<PageInfo, Status>

public expect fun TimelinesApi.getListSource(listId: String): PagingSource<PageInfo, Status>
