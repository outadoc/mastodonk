package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.BookmarksApi
import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class BookmarksApiImpl(private val client: MastodonHttpClient) : BookmarksApi {

    override suspend fun getBookmarks(maxId: String?, sinceId: String?, limit: Int?, minId: String?): List<Status> {
        return client.request("/api/v1/bookmarks") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
        }
    }
}
