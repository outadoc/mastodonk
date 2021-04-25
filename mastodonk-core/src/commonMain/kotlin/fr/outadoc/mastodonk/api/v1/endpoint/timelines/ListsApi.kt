package fr.outadoc.mastodonk.api.v1.endpoint.timelines

import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.RepliesPolicy
import fr.outadoc.mastodonk.api.v1.entity.UserList
import fr.outadoc.mastodonk.client.MastodonEndpoint

public interface ListsApi : MastodonEndpoint {

    // region List Metadata

    public suspend fun getOwnLists(): List<UserList>

    public suspend fun getList(id: String): UserList

    public suspend fun createList(title: String, repliesPolicy: RepliesPolicy?): UserList

    public suspend fun updateList(id: String, title: String?, repliesPolicy: RepliesPolicy?): UserList

    public suspend fun deleteList(id: String)

    // endregion

    // region List Contents

    public suspend fun getListAccounts(
        id: String,
        maxId: String? = null,
        sinceId: String? = null,
        limit: Int? = null
    ): List<Account>

    public suspend fun addAccountsToList(id: String, accountIds: List<String>)

    public suspend fun removeAccountsFromList(id: String, accountIds: List<String>)

    // endregion
}
