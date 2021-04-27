package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

/**
 * View featured profiles.
 *
 * @see [endorsements - Mastodon Documentation](https://docs.joinmastodon.org/methods/endorsements/)
 */
public interface EndorsementsApi {

    /**
     * Gets the list of accounts currently featured the current account's profile.
     */
    public suspend fun getEndorsements(limit: Int?, maxId: String?, sinceId: String?): List<Account>
}
