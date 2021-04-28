package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.RepliesPolicy
import fr.outadoc.mastodonk.api.entity.UserList
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class ListsApiImpl(private val client: MastodonHttpClient) : ListsApi {

    override suspend fun getOwnLists(): List<UserList> {
        return client.request("/api/v1/lists") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getList(listId: String): UserList? {
        return client.requestOrNull("/api/v1/lists/${listId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun createList(title: String, repliesPolicy: RepliesPolicy?): UserList {
        return client.request("/api/v1/lists") {
            method = HttpMethod.Post
            parameter("title", title)
            parameter("replies_policy", repliesPolicy)
        }
    }

    override suspend fun updateList(listId: String, title: String?, repliesPolicy: RepliesPolicy?): UserList {
        return client.request("/api/v1/lists/${listId.trim()}") {
            method = HttpMethod.Put
            parameter("title", title)
            parameter("replies_policy", repliesPolicy)
        }
    }

    override suspend fun deleteList(listId: String) {
        return client.request("/api/v1/lists/${listId.trim()}") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun getListAccounts(listId: String, maxId: String?, sinceId: String?, limit: Int?): List<Account>? {
        return client.requestOrNull("/api/v1/lists/${listId.trim()}/accounts") {
            method = HttpMethod.Get
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("limit", limit)
        }
    }

    override suspend fun addAccountsToList(listId: String, accountIds: List<String>) {
        return client.request("/api/v1/lists/${listId.trim()}/accounts") {
            method = HttpMethod.Post
            parameter("account_ids", accountIds)
        }
    }

    override suspend fun removeAccountsFromList(listId: String, accountIds: List<String>) {
        return client.request("/api/v1/lists/${listId.trim()}/accounts") {
            method = HttpMethod.Delete
            parameter("account_ids", accountIds)
        }
    }
}
