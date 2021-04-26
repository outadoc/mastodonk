package fr.outadoc.mastodonk.api.endpoint.search

import fr.outadoc.mastodonk.api.entity.Results
import fr.outadoc.mastodonk.api.entity.SearchType

public interface SearchApi {

    public suspend fun search(
        q: String,
        accountId: String? = null,
        type: SearchType? = null,
        excludeUnreviewed: Boolean? = null,
        attemptResolve: Boolean? = null,
        maxId: String? = null,
        minId: String? = null,
        limit: Int? = null,
        offset: Int? = null,
    ): Results
}
