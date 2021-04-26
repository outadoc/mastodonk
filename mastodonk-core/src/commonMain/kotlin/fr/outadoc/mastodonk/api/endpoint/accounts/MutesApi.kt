package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

public interface MutesApi {

    public suspend fun getMutes(maxId: String?, limit: Int?, sinceId: String?): List<Account>
}
