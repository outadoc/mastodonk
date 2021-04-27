package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

/**
 * View blocked accounts.
 */
public interface BlocksApi {

    /**
     * Gets all blocked accounts for this account.
     */
    public suspend fun getBlocks(maxId: String?, limit: Int?, sinceId: String?): List<Account>
}
