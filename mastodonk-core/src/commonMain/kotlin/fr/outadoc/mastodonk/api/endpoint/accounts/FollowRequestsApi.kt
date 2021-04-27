package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Relationship

/**
 * View and manage follow requests.
 *
 * @see [follow_requests - Mastodon Documentation](https://docs.joinmastodon.org/methods/follow_requests/)
 */
public interface FollowRequestsApi {

    /**
     * Gets the list of accounts with a pending follow request.
     */
    public suspend fun getPendingFollowRequests(limit: String?): List<Account>

    /**
     * Accepts a follow request from another [Account].
     */
    public suspend fun acceptFollowRequest(id: String): Relationship

    /**
     * Rejects a follow request from another [Account].
     */
    public suspend fun rejectFollowRequest(id: String): Relationship
}
