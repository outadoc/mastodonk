package fr.outadoc.mastodonk.api.endpoint.accounts

/**
 * View and manage blocked domains.
 */
public interface DomainBlocksApi {

    /**
     * Gets the list of blocked domains (Mastodon instances) for this account.
     */
    public suspend fun getDomainBlocks(maxId: String?, limit: Int?, sinceId: String?): List<String>

    /**
     * Blocks the domain of a Mastodon instance.
     *
     * Block a domain to:
     * - hide all public posts from it
     * - hide all notifications from it
     * - remove all followers from it
     * - prevent following new users from it (but does not remove existing follows)
     */
    public suspend fun blockDomain(domain: String)

    /**
     * Unblocks a domain.
     */
    public suspend fun unblockDomain(domain: String)
}
