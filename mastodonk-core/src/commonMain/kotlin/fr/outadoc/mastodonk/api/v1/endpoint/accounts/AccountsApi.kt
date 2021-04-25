package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.FeaturedTag
import fr.outadoc.mastodonk.api.v1.entity.IdentityProof
import fr.outadoc.mastodonk.api.v1.entity.Relationship
import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.api.v1.entity.Token
import fr.outadoc.mastodonk.api.v1.entity.UserList
import fr.outadoc.mastodonk.api.v1.entity.request.accounts.AccountCreate
import fr.outadoc.mastodonk.api.v1.entity.request.accounts.AccountUpdate

public interface AccountsApi {

    // region Account credentials

    public suspend fun register(account: AccountCreate): Token

    public suspend fun verifyCredentials(): Account

    public suspend fun updateCredentials(account: AccountUpdate): Account

    // endregion

    // region Retrieve information

    public suspend fun getAccount(id: String): Account

    public suspend fun getStatuses(id: String): List<Status>

    public suspend fun getFollowers(
        id: String,
        maxId: String? = null,
        sinceId: String? = null,
        limit: Int? = null
    ): List<Account>

    public suspend fun getFollowing(
        id: String,
        maxId: String? = null,
        sinceId: String? = null,
        limit: Int? = null
    ): List<Account>

    public suspend fun getFeaturedTags(id: String): List<FeaturedTag>

    public suspend fun getListsContainedIn(id: String): List<UserList>

    public suspend fun getIdentityProofs(id: String): List<IdentityProof>

    // endregion

    // region Perform actions on an account

    public suspend fun follow(id: String, reblogs: Boolean? = null, notify: Boolean? = null): Relationship

    public suspend fun unfollow(id: String): Relationship

    public suspend fun block(id: String): Relationship

    public suspend fun unblock(id: String): Relationship

    public suspend fun mute(id: String): Relationship

    public suspend fun unmute(id: String): Relationship

    public suspend fun feature(id: String): Relationship

    public suspend fun unfeature(id: String): Relationship

    public suspend fun note(id: String, comment: String? = null): Relationship

    // endregion

    // region General account actions

    public suspend fun getRelationships(ids: List<String>): List<Relationship>

    public suspend fun search(
        query: String,
        limit: Int? = null,
        resolve: Boolean? = null,
        following: Boolean? = null
    ): List<Account>

    // endregion
}
