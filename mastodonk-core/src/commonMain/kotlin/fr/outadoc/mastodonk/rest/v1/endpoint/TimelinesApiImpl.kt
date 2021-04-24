package fr.outadoc.mastodonk.rest.v1.endpoint

import fr.outadoc.mastodonk.api.v1.endpoint.TimelinesApi
import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.rest.v1.MastodonHttpClient

internal class TimelinesApiImpl(private val client: MastodonHttpClient) : TimelinesApi {

    override suspend fun getPublicTimeline(
        onlyLocal: Boolean?,
        onlyRemote: Boolean?,
        onlyMedia: Boolean?,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Status> {
        return client.get("/api/v1/timelines/public")
    }

    override suspend fun getHashtagTimeline(
        hashtag: String,
        onlyLocal: Boolean?,
        onlyMedia: Boolean?,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Status> {
        TODO("Not yet implemented")
    }

    override suspend fun getHomeTimeline(
        onlyLocal: Boolean?,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Status> {
        TODO("Not yet implemented")
    }

    override suspend fun getList(
        listId: String,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Status> {
        TODO("Not yet implemented")
    }
}