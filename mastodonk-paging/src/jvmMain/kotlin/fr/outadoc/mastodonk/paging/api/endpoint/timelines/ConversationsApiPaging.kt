package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.ConversationsApi
import fr.outadoc.mastodonk.api.entity.Conversation
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun ConversationsApi.getConversationsSource(): PagingSource<PageInfo, Conversation> {
    return pagingSource { params ->
        getConversations(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
