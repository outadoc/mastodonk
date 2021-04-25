package fr.outadoc.mastodonk.api.v1.endpoint.timelines

import fr.outadoc.mastodonk.client.MastodonEndpoint
import fr.outadoc.mastodonk.api.v1.entity.Status

public interface TimelinesApi : MastodonEndpoint {

    public suspend fun getPublicTimeline(
        onlyLocal: Boolean? = null,
        onlyRemote: Boolean? = null,
        onlyMedia: Boolean? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null
    ): List<Status>

    public suspend fun getHashtagTimeline(
        hashtag: String,
        onlyLocal: Boolean? = null,
        onlyMedia: Boolean? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null
    ): List<Status>

    public suspend fun getHomeTimeline(
        onlyLocal: Boolean? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null
    ): List<Status>

    public suspend fun getList(
        listId: String,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null
    ): List<Status>
}