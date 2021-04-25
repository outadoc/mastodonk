package fr.outadoc.mastodonk.api.v1.repository.accounts

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.FeaturedTag
import fr.outadoc.mastodonk.api.v1.entity.IdentityProof
import fr.outadoc.mastodonk.api.v1.entity.Relationship
import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.api.v1.entity.Token
import fr.outadoc.mastodonk.api.v1.entity.UserList
import fr.outadoc.mastodonk.api.v1.entity.request.accounts.AccountCreate
import fr.outadoc.mastodonk.api.v1.entity.request.accounts.AccountUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class AccountsApiImpl(private val client: MastodonHttpClient) : AccountsApi {

    override suspend fun register(account: AccountCreate): Token {
        return client.request("/api/v1/accounts") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = account
        }
    }

    override suspend fun verifyCredentials(): Account {
        return client.request("/api/v1/accounts/verify_credentials") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateCredentials(account: AccountUpdate): Account {
        return client.request("/api/v1/accounts/update_credentials") {
            method = HttpMethod.Patch
            contentType(ContentType.Application.Json)
            body = account
        }
    }

    override suspend fun getAccount(id: String): Account {
        return client.request("/api/v1/accounts/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getStatuses(id: String): List<Status> {
        return client.request("/api/v1/accounts/${id.trim()}/statuses") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getFollowers(id: String, maxId: String?, sinceId: String?, limit: Int?): List<Account> {
        return client.request("/api/v1/accounts/${id.trim()}/followers") {
            method = HttpMethod.Get
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("limit", limit)
        }
    }

    override suspend fun getFollowing(id: String, maxId: String?, sinceId: String?, limit: Int?): List<Account> {
        return client.request("/api/v1/accounts/${id.trim()}/following") {
            method = HttpMethod.Get
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("limit", limit)
        }
    }

    override suspend fun getFeaturedTags(id: String): List<FeaturedTag> {
        return client.request("/api/v1/accounts/${id.trim()}/featured_tags") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getListsContainedIn(id: String): List<UserList> {
        return client.request("/api/v1/accounts/${id.trim()}/lists") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getIdentityProofs(id: String): List<IdentityProof> {
        return client.request("/api/v1/accounts/${id.trim()}/identity_proofs") {
            method = HttpMethod.Get
        }
    }

    override suspend fun follow(id: String, reblogs: Boolean?, notify: Boolean?): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/follow") {
            method = HttpMethod.Post
            formData {
                reblogs?.let { append("reblogs", it.toString()) }
                notify?.let { append("notify", it.toString()) }
            }
        }
    }

    override suspend fun unfollow(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unfollow") {
            method = HttpMethod.Post
        }
    }

    override suspend fun block(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/block") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unblock(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unblock") {
            method = HttpMethod.Post
        }
    }

    override suspend fun mute(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/mute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unmute(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unmute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun pin(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/pin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unpin(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unpin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun note(id: String, comment: String?): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/note") {
            method = HttpMethod.Post
            formData {
                comment?.let { append("comment", it) }
            }
        }
    }

    override suspend fun getRelationships(ids: List<String>): List<Relationship> {
        return client.request("/api/v1/accounts/relationships") {
            method = HttpMethod.Post
            formData {
                ids.forEach { append("id", it) }
            }
        }
    }

    override suspend fun search(query: String, limit: Int?, resolve: Boolean?, following: Boolean?): List<Account> {
        return client.request("/api/v1/accounts/search") {
            method = HttpMethod.Get
            parameter("q", query)
            parameter("limit", limit)
            parameter("resolve", resolve)
            parameter("following", following)
        }
    }
}