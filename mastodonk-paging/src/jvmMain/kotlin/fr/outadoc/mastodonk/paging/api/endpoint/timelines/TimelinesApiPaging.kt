package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import androidx.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public fun TimelinesApi.getPublicTimelineSource(
    onlyLocal: Boolean? = null,
    onlyRemote: Boolean? = null,
    onlyMedia: Boolean? = null
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

public fun TimelinesApi.getHashtagTimelineSource(
    hashtag: String,
    onlyLocal: Boolean? = null,
    onlyMedia: Boolean? = null
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

public fun TimelinesApi.getHomeTimelineSource(onlyLocal: Boolean?): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getHomeTimeline(
            onlyLocal = onlyLocal,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public fun TimelinesApi.getListSource(listId: String): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getList(
            listId = listId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
