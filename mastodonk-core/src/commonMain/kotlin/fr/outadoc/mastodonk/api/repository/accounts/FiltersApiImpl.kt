package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.FiltersApi
import fr.outadoc.mastodonk.api.entity.Filter
import fr.outadoc.mastodonk.api.entity.request.FilterCreate
import fr.outadoc.mastodonk.api.entity.request.FilterUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class FiltersApiImpl(private val client: MastodonHttpClient) : FiltersApi {

    override suspend fun getFilters(): List<Filter> {
        return client.request("/api/v1/filters") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getFilter(filterId: String): Filter? {
        return client.requestOrNull("/api/v1/filters/${filterId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun createFilter(filter: FilterCreate): Filter {
        return client.request("/api/v1/filters") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = filter
        }
    }

    override suspend fun updateFilter(filter: FilterUpdate): Filter? {
        return client.requestOrNull("/api/v1/filters") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            body = filter
        }
    }

    override suspend fun deleteFilter(filterId: String) {
        return client.request("/api/v1/filters/${filterId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
