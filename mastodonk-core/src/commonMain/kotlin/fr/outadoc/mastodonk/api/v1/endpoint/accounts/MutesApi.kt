package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Account

public interface MutesApi {

    public suspend fun getMutes(maxId: String?, limit: Int?, sinceId: String?): List<Account>
}
