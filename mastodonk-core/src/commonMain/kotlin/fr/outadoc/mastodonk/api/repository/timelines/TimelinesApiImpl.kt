package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class TimelinesApiImpl(private val client: MastodonHttpClient) : TimelinesApi {

    override suspend fun getPublicTimeline(
        onlyLocal: Boolean?,
        onlyRemote: Boolean?,
        onlyMedia: Boolean?,
        pageInfo: PageInfo?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/public") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("remote", onlyRemote)
            parameter("only_media", onlyMedia)
            parameter(pageInfo)
        }
    }

    override suspend fun getHashtagTimeline(
        hashtag: String,
        onlyLocal: Boolean?,
        onlyMedia: Boolean?,
        pageInfo: PageInfo?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/tag/${hashtag.trim()}") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("only_media", onlyMedia)
            parameter(pageInfo)
        }
    }

    override suspend fun getHomeTimeline(
        onlyLocal: Boolean?,
        pageInfo: PageInfo?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/home") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter(pageInfo)
        }
    }

    override suspend fun getList(
        listId: String,
        pageInfo: PageInfo?
    ): Page<List<Status>>? {
        return client.requestPageOrNull("/api/v1/timelines/list/${listId.trim()}") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }
}
