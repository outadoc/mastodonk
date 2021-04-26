package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Status

public interface FavouritesApi {

    public suspend fun getFavourites(maxId: String?, limit: Int?, minId: String?): List<Status>
}