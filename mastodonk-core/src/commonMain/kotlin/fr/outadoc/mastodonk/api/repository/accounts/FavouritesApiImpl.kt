package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.FavouritesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class FavouritesApiImpl(private val client: MastodonHttpClient) : FavouritesApi {

    override suspend fun getFavourites(maxId: String?, limit: Int?, minId: String?): List<Status> {
        return client.request("/api/v1/favourites") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId)
            parameter("min_id", minId)
        }
    }
}
