package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.DirectoryOrder

/**
 * View the directory of accounts published by the instance.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/directory/)
 */
public interface DirectoryApi {

    /**
     * Lists accounts visible in the directory.
     *
     * @param order [DirectoryOrder.Active] to sort by most recently posted statuses,
     * or [DirectoryOrder.New] to sort by most recently created accounts.
     * @param onlyLocal Only show local accounts.
     */
    public suspend fun getDirectory(
        order: DirectoryOrder? = null,
        onlyLocal: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null
    ): List<Account>
}
