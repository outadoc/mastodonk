package fr.outadoc.mastodonk.api.endpoint.admin

import fr.outadoc.mastodonk.api.entity.AdminAccount
import fr.outadoc.mastodonk.api.entity.AdminReport
import fr.outadoc.mastodonk.api.entity.request.admin.AccountAction

/**
 * Methods reserved to instance administrators.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/admin/)
 */
public interface AdminApi {

    // region Account methods

    /**
     * Gets a list of accounts matching certain criteria.
     *
     * @param local Filter for local accounts?
     * @param remote Filter for remote accounts?
     * @param active Filter for currently active accounts?
     * @param pending Filter for currently pending accounts?
     * @param disabled Filter for currently disabled accounts?
     * @param silenced Filter for currently silenced accounts?
     * @param suspended Filter for currently suspended accounts?
     * @param staff Filter for staff accounts?
     * @param username Filter by username
     * @param displayName Filter by display name
     * @param email Filter by email address
     * @param domain Filter by the given domain
     * @param ip Filter by IP address
     */
    public suspend fun getAccounts(
        local: Boolean?,
        remote: Boolean?,
        active: Boolean?,
        pending: Boolean?,
        disabled: Boolean?,
        silenced: Boolean?,
        suspended: Boolean?,
        staff: Boolean?,
        domain: String?,
        username: String?,
        displayName: String?,
        email: String?,
        ip: String?
    ): AdminAccount

    /**
     * Gets a specific account with admin-level information.
     */
    public suspend fun getAccount(accountId: String): AdminAccount

    /**
     * Performs an action against an account and logs this action in the moderation history.
     */
    public suspend fun performAction(accountId: String, action: AccountAction)

    /**
     * Approves the given local account if it is currently pending approval.
     */
    public suspend fun approvePendingAccount(accountId: String): AdminAccount

    /**
     * Rejects the given local account if it is currently pending approval.
     */
    public suspend fun rejectPendingAccount(accountId: String): AdminAccount

    /**
     * Re-enable a local account whose login is currently disabled.
     */
    public suspend fun reenableAccount(accountId: String): AdminAccount

    /**
     * Unsilence a currently silenced account.
     */
    public suspend fun unsilenceAccount(accountId: String): AdminAccount

    /**
     * Unsuspend a currently suspended account.
     */
    public suspend fun unsuspendAccount(accountId: String): AdminAccount

    // endregion

    // region Report methods

    /**
     * Gets a list of reports matching the given criteria.
     */
    public suspend fun getReports(
        isResolved: Boolean? = null,
        accountId: String? = null,
        targetAccountId: String? = null
    ): List<AdminReport>

    /**
     * Gets information about a specific report.
     */
    public suspend fun getReport(reportId: String): AdminReport

    /**
     * Assigns the handling of this report to the current account.
     */
    public suspend fun assignReportToSelf(reportId: String): AdminReport

    /**
     * Un-assigns a report, so that another account may be assigned to it.
     */
    public suspend fun unassignReport(reportId: String): AdminReport

    /**
     * Marks a report as resolved.
     */
    public suspend fun resolveReport(reportId: String): AdminReport

    /**
     * Re-opens a currently closed report.
     */
    public suspend fun reopenReport(reportId: String): AdminReport

    // endregion
}
