package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.BookmarksApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class BookmarksApiImpl(private val client: MastodonHttpClient) : BookmarksApi {

    override suspend fun getBookmarks(limit: Int?, pageInfo: PageInfo?): Page<List<Status>> {
        return client.requestPage("/api/v1/bookmarks") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }
}
