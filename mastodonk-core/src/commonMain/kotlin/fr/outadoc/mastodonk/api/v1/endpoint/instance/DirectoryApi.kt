package fr.outadoc.mastodonk.api.v1.endpoint.instance

import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.DirectoryOrder

public interface DirectoryApi {

    public suspend fun getDirectory(
        order: DirectoryOrder? = null,
        onlyLocal: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null
    ): List<Account>
}