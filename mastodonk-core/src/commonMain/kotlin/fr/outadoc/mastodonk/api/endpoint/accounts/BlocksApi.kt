package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account

public interface BlocksApi {

    public suspend fun getBlocks(maxId: String?, limit: Int?, sinceId: String?): List<Account>
}
