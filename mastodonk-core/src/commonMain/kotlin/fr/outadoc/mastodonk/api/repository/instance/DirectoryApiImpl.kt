package fr.outadoc.mastodonk.api.repository.instance

import fr.outadoc.mastodonk.api.endpoint.instance.DirectoryApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.DirectoryOrder
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class DirectoryApiImpl(private val client: MastodonHttpClient) : DirectoryApi {

    override suspend fun getDirectory(
        order: DirectoryOrder?,
        onlyLocal: Boolean?,
        limit: Int?,
        offset: Int?
    ): List<Account> {
        return client.request("/api/v1/directory") {
            method = HttpMethod.Get
            parameter("order", order?.let { Json.Default.encodeToString(it) })
            parameter("local", onlyLocal)
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }
}
