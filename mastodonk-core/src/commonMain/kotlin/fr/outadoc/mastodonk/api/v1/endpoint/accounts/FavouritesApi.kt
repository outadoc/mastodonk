package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Status

public interface FavouritesApi {

    public suspend fun getFavourites(maxId: String?, limit: Int?, minId: String?): List<Status>
}