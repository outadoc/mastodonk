package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.FeaturedTag
import fr.outadoc.mastodonk.api.entity.Field
import fr.outadoc.mastodonk.api.entity.IdentityProof
import fr.outadoc.mastodonk.api.entity.Relationship
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.UserList
import fr.outadoc.mastodonk.api.entity.Visibility
import fr.outadoc.mastodonk.api.entity.request.File
import fr.outadoc.mastodonk.api.entity.request.accounts.AccountCreate
import fr.outadoc.mastodonk.api.entity.request.toFormPart
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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

    override suspend fun updateCredentials(
        displayName: String?,
        note: String?,
        avatar: File?,
        header: File?,
        isBot: Boolean?,
        isDiscoverable: Boolean?,
        isLocked: Boolean?,
        isSensitive: Boolean?,
        privacy: Visibility?,
        language: String?,
        fields: List<Field>?
    ): Account {
        val avatarPart = avatar?.toFormPart("avatar")
        val headerPart = header?.toFormPart("header")

        return client.request("/api/v1/accounts/update_credentials") {
            method = HttpMethod.Patch
            formData {
                displayName?.let {
                    append("display_name", it)
                }

                isBot?.let {
                    append("bot", it.toString())
                }

                isDiscoverable?.let {
                    append("discoverable", it.toString())
                }

                isLocked?.let {
                    append("locked", it.toString())
                }

                fields?.forEach {
                    append("fields_attributes[][name]", it.name)
                    append("fields_attributes[][value]", it.value)
                }

                privacy?.let {
                    append("source[privacy]", Json.Default.encodeToString(it))
                }

                isSensitive?.let {
                    append("source[sensitive]", it.toString())
                }

                language?.let {
                    append("source[language]", it)
                }

                avatarPart?.let { append(it) }
                headerPart?.let { append(it) }
            }
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

    override suspend fun getFollowers(
        id: String,
        maxId: String?,
        sinceId: String?,
        limit: Int?
    ): List<Account> {
        return client.request("/api/v1/accounts/${id.trim()}/followers") {
            method = HttpMethod.Get
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("limit", limit)
        }
    }

    override suspend fun getFollowing(
        id: String,
        maxId: String?,
        sinceId: String?,
        limit: Int?
    ): List<Account> {
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

    override suspend fun followAccount(
        id: String,
        reblogs: Boolean?,
        notify: Boolean?
    ): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/follow") {
            method = HttpMethod.Post
            formData {
                reblogs?.let { append("reblogs", it.toString()) }
                notify?.let { append("notify", it.toString()) }
            }
        }
    }

    override suspend fun unfollowAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unfollow") {
            method = HttpMethod.Post
        }
    }

    override suspend fun blockAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/block") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unblockAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unblock") {
            method = HttpMethod.Post
        }
    }

    override suspend fun muteAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/mute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unmuteAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unmute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun featureAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/pin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unfeatureAccount(id: String): Relationship {
        return client.request("/api/v1/accounts/${id.trim()}/unpin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun commentOnAccount(id: String, comment: String?): Relationship {
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

    override suspend fun search(
        query: String,
        limit: Int?,
        resolve: Boolean?,
        following: Boolean?
    ): List<Account> {
        return client.request("/api/v1/accounts/search") {
            method = HttpMethod.Get
            parameter("q", query)
            parameter("limit", limit)
            parameter("resolve", resolve)
            parameter("following", following)
        }
    }
}
