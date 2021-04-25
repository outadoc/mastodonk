package fr.outadoc.mastodonk.api.v1.repository.instance

import fr.outadoc.mastodonk.api.v1.endpoint.instance.TrendsApi
import fr.outadoc.mastodonk.api.v1.entity.Tag
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class TrendsApiImpl(private val client: MastodonHttpClient) : TrendsApi {

    override suspend fun getTrends(limit: Int?): List<Tag> {
        return client.request("/api/v1/trends") {
            method = HttpMethod.Get
            parameter("limit", limit)
        }
    }
}