package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View favourites.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/favourites/)
 */
public interface FavouritesApi {

    /**
     * Gets the current account's favourite statuses.
     */
    public suspend fun getFavourites(limit: Int? = null, pageInfo: PageInfo? = null): Page<List<Status>>
}
