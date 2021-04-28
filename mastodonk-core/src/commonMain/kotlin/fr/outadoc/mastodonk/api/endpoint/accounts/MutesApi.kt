package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View muted accounts.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/mutes/)
 */
public interface MutesApi {

    /**
     * Gets the list of accounts that are muted by the current account.
     */
    public suspend fun getMutes(pageInfo: PageInfo? = null): Page<List<Account>>
}
