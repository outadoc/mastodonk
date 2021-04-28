package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View featured profiles.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/endorsements/)
 */
public interface EndorsementsApi {

    /**
     * Gets the list of accounts currently featured the current account's profile.
     */
    public suspend fun getEndorsements(pageInfo: PageInfo? = null): Page<List<Account>>
}
