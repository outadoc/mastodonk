package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Status

/**
 * View favourites.
 *
 * @see [favourites - Mastodon Documentation](https://docs.joinmastodon.org/methods/favourites/)
 */
public interface FavouritesApi {

    /**
     * Gets the current account's favourite statuses.
     */
    public suspend fun getFavourites(maxId: String?, limit: Int?, minId: String?): List<Status>
}
