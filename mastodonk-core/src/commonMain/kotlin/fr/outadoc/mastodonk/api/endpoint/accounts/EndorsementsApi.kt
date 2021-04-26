package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

public interface EndorsementsApi {

    public suspend fun getEndorsements(limit: Int?, maxId: String?, sinceId: String?): List<Account>
}
