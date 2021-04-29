package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.FeaturedTag
import fr.outadoc.mastodonk.api.entity.Field
import fr.outadoc.mastodonk.api.entity.IdentityProof
import fr.outadoc.mastodonk.api.entity.Relationship
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.StatusVisibility
import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.UserList
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.api.entity.request.AccountCreate
import fr.outadoc.mastodonk.api.entity.request.File
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
        privacy: StatusVisibility?,
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

    override suspend fun getAccount(accountId: String): Account? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getStatuses(accountId: String): List<Status>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/statuses") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getFollowers(accountId: String, pageInfo: PageInfo?): Page<List<Account>>? {
        return client.requestPageOrNull("/api/v1/accounts/${accountId.trim()}/followers") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }

    override suspend fun getFollowing(accountId: String, pageInfo: PageInfo?): Page<List<Account>>? {
        return client.requestPageOrNull("/api/v1/accounts/${accountId.trim()}/following") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }

    override suspend fun getFeaturedTags(accountId: String): List<FeaturedTag>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/featured_tags") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getListsContainedIn(accountId: String): List<UserList>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/lists") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getIdentityProofs(accountId: String): List<IdentityProof>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/identity_proofs") {
            method = HttpMethod.Get
        }
    }

    override suspend fun followAccount(
        accountId: String,
        reblogs: Boolean?,
        notify: Boolean?
    ): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/follow") {
            method = HttpMethod.Post
            formData {
                reblogs?.let { append("reblogs", it.toString()) }
                notify?.let { append("notify", it.toString()) }
            }
        }
    }

    override suspend fun unfollowAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unfollow") {
            method = HttpMethod.Post
        }
    }

    override suspend fun blockAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/block") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unblockAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unblock") {
            method = HttpMethod.Post
        }
    }

    override suspend fun muteAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/mute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unmuteAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unmute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun featureAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/pin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unfeatureAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unpin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun commentOnAccount(accountId: String, comment: String?): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/note") {
            method = HttpMethod.Post
            formData {
                comment?.let { append("comment", it) }
            }
        }
    }

    override suspend fun getRelationships(accountIds: List<String>): List<Relationship> {
        return client.request("/api/v1/accounts/relationships") {
            method = HttpMethod.Post
            formData {
                accountIds.forEach { append("id", it) }
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
