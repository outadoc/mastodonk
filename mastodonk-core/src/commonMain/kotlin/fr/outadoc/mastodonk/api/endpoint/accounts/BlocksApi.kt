package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View blocked accounts.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/blocks/)
 */
public interface BlocksApi {

    /**
     * Gets all blocked accounts for this account.
     */
    public suspend fun getBlocks(pageInfo: PageInfo? = null): Page<List<Account>>
}
