package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PaginationState
import fr.outadoc.mastodonk.api.entity.paging.append
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class TimelinesApiImpl(private val client: MastodonHttpClient) : TimelinesApi {

    override suspend fun getPublicTimeline(
        onlyLocal: Boolean?,
        onlyRemote: Boolean?,
        onlyMedia: Boolean?,
        paginationState: PaginationState?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/public") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("remote", onlyRemote)
            parameter("only_media", onlyMedia)
            append(paginationState)
        }
    }

    override suspend fun getHashtagTimeline(
        hashtag: String,
        onlyLocal: Boolean?,
        onlyMedia: Boolean?,
        paginationState: PaginationState?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/tag/${hashtag.trim()}") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("only_media", onlyMedia)
            append(paginationState)
        }
    }

    override suspend fun getHomeTimeline(
        onlyLocal: Boolean?,
        paginationState: PaginationState?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/home") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            append(paginationState)
        }
    }

    override suspend fun getList(
        listId: String,
        paginationState: PaginationState?
    ): Page<List<Status>>? {
        return client.requestPageOrNull("/api/v1/timelines/list/${listId.trim()}") {
            method = HttpMethod.Get
            append(paginationState)
        }
    }
}
