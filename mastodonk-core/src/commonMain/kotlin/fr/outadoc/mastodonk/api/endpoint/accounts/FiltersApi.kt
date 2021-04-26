package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Filter
import fr.outadoc.mastodonk.api.entity.request.accounts.FilterCreate
import fr.outadoc.mastodonk.api.entity.request.accounts.FilterUpdate

public interface FiltersApi {

    public suspend fun getFilters(): List<Filter>

    public suspend fun getFilter(id: String): Filter

    public suspend fun createFilter(filter: FilterCreate): Filter

    public suspend fun updateFilter(filter: FilterUpdate): Filter

    public suspend fun deleteFilter(id: String)
}
