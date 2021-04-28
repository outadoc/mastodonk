package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class TimelinesApiImpl(private val client: MastodonHttpClient) : TimelinesApi {

    override suspend fun getPublicTimeline(
        onlyLocal: Boolean?,
        onlyRemote: Boolean?,
        onlyMedia: Boolean?,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/public") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("remote", onlyRemote)
            parameter("only_media", onlyMedia)
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("limit", limit)
        }
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
        return client.request("/api/v1/timelines/tag/${hashtag.trim()}") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("only_media", onlyMedia)
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("limit", limit)
        }
    }

    override suspend fun getHomeTimeline(
        onlyLocal: Boolean?,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Status> {
        return client.request("/api/v1/timelines/home") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("limit", limit)
        }
    }

    override suspend fun getList(
        listId: String,
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?
    ): List<Status>? {
        return client.requestOrNull("/api/v1/timelines/list/${listId.trim()}") {
            method = HttpMethod.Get
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("limit", limit)
        }
    }
}
