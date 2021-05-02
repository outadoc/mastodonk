package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun TimelinesApi.getPublicTimelineSource(
    onlyLocal: Boolean?,
    onlyRemote: Boolean?,
    onlyMedia: Boolean?
): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getPublicTimeline(
            onlyLocal = onlyLocal,
            onlyRemote = onlyRemote,
            onlyMedia = onlyMedia,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public actual fun TimelinesApi.getHashtagTimelineSource(
    hashtag: String,
    onlyLocal: Boolean?,
    onlyMedia: Boolean?
): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getHashtagTimeline(
            hashtag = hashtag,
            onlyLocal = onlyLocal,
            onlyMedia = onlyMedia,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public actual fun TimelinesApi.getHomeTimelineSource(onlyLocal: Boolean?): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getHomeTimeline(
            onlyLocal = onlyLocal,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public actual fun TimelinesApi.getListSource(listId: String): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getList(
            listId = listId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
