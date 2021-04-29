package fr.outadoc.mastodonk.api.endpoint.accounts

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
import fr.outadoc.mastodonk.api.entity.request.AccountCreate
import fr.outadoc.mastodonk.api.entity.request.File

/**
 * Methods concerning user accounts and related information.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/)
 */
public interface AccountsApi {

    // region Account credentials

    /**
     * Creates a user and account records.
     *
     * @return Account access token for the app that initiated the request.
     * The app should save this token for later, and should wait for the user to confirm
     * their account by clicking a link in their email inbox.
     */
    public suspend fun register(account: AccountCreate): Token

    /**
     * Verifies that the user token works.
     */
    public suspend fun verifyCredentials(): Account

    /**
     * Updates the user's display and preferences.
     *
     * @param displayName The account's display name.
     * @param note The account bio.
     * @param avatar The account's avatar.
     * @param header The account's header image.
     * @param isBot Whether the account should identify itself as a bot.
     * @param isDiscoverable Whether the account should be shown in the profile directory.
     * @param isLocked Whether manual approval of follow requests is required.
     * @param isSensitive Whether to mark authored statuses as sensitive by default.
     * @param privacy Default post privacy for authored statuses.
     * @param language Default language to use for authored statuses. (ISO 6391)
     * @param fields Profile metadata name and value.
     */
    public suspend fun updateCredentials(
        displayName: String? = null,
        note: String? = null,
        avatar: File? = null,
        header: File? = null,
        isBot: Boolean? = null,
        isDiscoverable: Boolean? = null,
        isLocked: Boolean? = null,
        isSensitive: Boolean? = null,
        privacy: StatusVisibility? = null,
        language: String? = null,
        fields: List<Field>? = null
    ): Account

    // endregion

    // region Retrieve information

    /**
     * Gets information about a profile.
     */
    public suspend fun getAccount(accountId: String): Account?

    /**
     * Gets statuses posted by the given account.
     */
    public suspend fun getStatuses(accountId: String): List<Status>?

    /**
     * Gets the list of accounts which follow the given account,
     * if network is not hidden by the account owner.
     */
    public suspend fun getFollowers(accountId: String, pageInfo: PageInfo? = null): Page<List<Account>>?

    /**
     * Gets the list of accounts which the given account is following,
     * if network is not hidden by the account owner.
     */
    public suspend fun getFollowing(accountId: String, pageInfo: PageInfo? = null): Page<List<Account>>?

    /**
     * Gets tags featured by this account.
     */
    public suspend fun getFeaturedTags(accountId: String): List<FeaturedTag>?

    /**
     * Gets the user lists that you have added this account to.
     */
    public suspend fun getListsContainedIn(accountId: String): List<UserList>?

    /**
     * Gets identity proofs for this account.
     */
    public suspend fun getIdentityProofs(accountId: String): List<IdentityProof>?

    // endregion

    // region Perform actions on an account

    /**
     * Follows the given account.
     *
     * Can also be used to update whether to show reblogs or enable notifications.
     */
    public suspend fun followAccount(
        accountId: String,
        reblogs: Boolean? = null,
        notify: Boolean? = null
    ): Relationship

    /**
     * Unfollows the given account.
     */
    public suspend fun unfollowAccount(accountId: String): Relationship

    /**
     * Blocks the given account.
     *
     * Clients should filter statuses from this account,
     * if received (e.g. due to a boost in the Home timeline).
     */
    public suspend fun blockAccount(accountId: String): Relationship

    /**
     * Unblocks the given account.
     */
    public suspend fun unblockAccount(accountId: String): Relationship

    /**
     * Mutes the given account.
     *
     * Clients should filter statuses and notifications from this account,
     * if received (e.g. due to a boost in the Home timeline).
     */
    public suspend fun muteAccount(accountId: String): Relationship

    /**
     * Unmutes the given account.
     */
    public suspend fun unmuteAccount(accountId: String): Relationship

    /**
     * Adds the given account to the user's featured profiles.
     */
    public suspend fun featureAccount(accountId: String): Relationship

    /**
     * Removes the given account from the user's featured profiles.
     */
    public suspend fun unfeatureAccount(accountId: String): Relationship

    /**
     * Sets a private note on a user.
     */
    public suspend fun commentOnAccount(accountId: String, comment: String? = null): Relationship

    // endregion

    // region General account actions

    /**
     * Gets the relationship between the current account and the given accounts.
     *
     * Find out whether given accounts are followed, blocked, muted, etc.
     */
    public suspend fun getRelationships(accountIds: List<String>): List<Relationship>

    /**
     * Searches for matching accounts by username or display name.
     */
    public suspend fun search(
        query: String,
        limit: Int? = null,
        resolve: Boolean? = null,
        following: Boolean? = null
    ): List<Account>

    // endregion
}
