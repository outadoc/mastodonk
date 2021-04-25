package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Account

public interface EndorsementsApi {

    public suspend fun getEndorsements(limit: Int?, maxId: String?, sinceId: String?): List<Account>
}
