package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.FavouritesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class FavouritesApiImpl(private val client: MastodonHttpClient) : FavouritesApi {

    override suspend fun getFavourites(pageInfo: PageInfo?): Page<List<Status>> {
        return client.requestPage("/api/v1/favourites") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }
}
