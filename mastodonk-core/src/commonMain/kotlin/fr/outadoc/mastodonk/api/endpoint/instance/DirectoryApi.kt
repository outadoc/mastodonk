package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.DirectoryOrder

public interface DirectoryApi {

    public suspend fun getDirectory(
        order: DirectoryOrder? = null,
        onlyLocal: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null
    ): List<Account>
}
