package fr.outadoc.mastodonk.api.endpoint.admin

import fr.outadoc.mastodonk.api.entity.AdminAccount
import fr.outadoc.mastodonk.api.entity.AdminReport
import fr.outadoc.mastodonk.api.entity.request.admin.AccountAction

public interface AdminApi {

    // region Account methods

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

    public suspend fun getAccount(id: String): AdminAccount

    public suspend fun performAction(accountId: String, action: AccountAction)

    public suspend fun approvePendingAccount(id: String): AdminAccount

    public suspend fun rejectPendingAccount(id: String): AdminAccount

    public suspend fun reenableAccount(id: String): AdminAccount

    public suspend fun unsilenceAccount(id: String): AdminAccount

    public suspend fun unsuspendAccount(id: String): AdminAccount

    // endregion

    // region Report methods

    public suspend fun getAllReports(
        resolved: Boolean? = null,
        accountId: String? = null,
        targetAccountId: String? = null
    ): List<AdminAccount>

    public suspend fun getReport(id: String): AdminAccount

    public suspend fun assignReportToSelf(id: String): AdminReport

    public suspend fun unassignReport(id: String): AdminReport

    public suspend fun resolveReport(id: String): AdminReport

    public suspend fun reopenReport(id: String): AdminReport

    // endregion
}
