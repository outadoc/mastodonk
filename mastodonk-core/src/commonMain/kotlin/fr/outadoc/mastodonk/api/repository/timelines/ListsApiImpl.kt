package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.ListReplyPolicy
import fr.outadoc.mastodonk.api.entity.UserList
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
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

    override suspend fun createList(title: String, replyPolicy: ListReplyPolicy?): UserList {
        return client.request("/api/v1/lists") {
            method = HttpMethod.Post
            parameter("title", title)
            parameter("replies_policy", replyPolicy)
        }
    }

    override suspend fun updateList(listId: String, title: String?, replyPolicy: ListReplyPolicy?): UserList {
        return client.request("/api/v1/lists/${listId.trim()}") {
            method = HttpMethod.Put
            parameter("title", title)
            parameter("replies_policy", replyPolicy)
        }
    }

    override suspend fun deleteList(listId: String) {
        return client.request("/api/v1/lists/${listId.trim()}") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun getListAccounts(listId: String, limit: Int?, pageInfo: PageInfo?): Page<List<Account>>? {
        return client.requestPageOrNull("/api/v1/lists/${listId.trim()}/accounts") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
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
