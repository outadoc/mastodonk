package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Account

public interface BlocksApi {

    public suspend fun getBlocks(maxId: String?, limit: Int?, sinceId: String?): List<Account>
}