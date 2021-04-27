package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Filter
import fr.outadoc.mastodonk.api.entity.request.accounts.FilterCreate
import fr.outadoc.mastodonk.api.entity.request.accounts.FilterUpdate

/**
 * View and manage filters.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/filters/)
 */
public interface FiltersApi {

    /**
     * Gets the list of filters set up on this account.
     */
    public suspend fun getFilters(): List<Filter>

    /**
     * Gets a single [Filter].
     */
    public suspend fun getFilter(id: String): Filter

    /**
     * Creates a new [Filter].
     */
    public suspend fun createFilter(filter: FilterCreate): Filter

    /**
     * Updates an existing [Filter].
     */
    public suspend fun updateFilter(filter: FilterUpdate): Filter

    /**
     * Deletes a [Filter].
     */
    public suspend fun deleteFilter(id: String)
}
