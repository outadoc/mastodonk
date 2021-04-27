package fr.outadoc.mastodonk.api.repository.admin

import fr.outadoc.mastodonk.api.endpoint.admin.AdminApi
import fr.outadoc.mastodonk.api.entity.AdminAccount
import fr.outadoc.mastodonk.api.entity.AdminReport
import fr.outadoc.mastodonk.api.entity.request.admin.AccountAction
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class AdminApiImpl(private val client: MastodonHttpClient) : AdminApi {

    override suspend fun getAccounts(
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
    ): AdminAccount {
        return client.request("/api/v1/admin/accounts") {
            method = HttpMethod.Get
            parameter("local", local)
            parameter("remote", remote)
            parameter("active", active)
            parameter("pending", pending)
            parameter("disabled", disabled)
            parameter("silenced", silenced)
            parameter("suspended", suspended)
            parameter("staff", staff)
            parameter("by_domain", domain)
            parameter("username", username)
            parameter("display_name", displayName)
            parameter("email", email)
            parameter("ip", ip)
        }
    }

    override suspend fun getAccount(accountId: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun performAction(accountId: String, action: AccountAction) {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}/action") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = action
        }
    }

    override suspend fun approvePendingAccount(accountId: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}/approve") {
            method = HttpMethod.Post
        }
    }

    override suspend fun rejectPendingAccount(accountId: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}/reject") {
            method = HttpMethod.Post
        }
    }

    override suspend fun reenableAccount(accountId: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}/enable") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unsilenceAccount(accountId: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}/unsilence") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unsuspendAccount(accountId: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${accountId.trim()}/unsuspend") {
            method = HttpMethod.Post
        }
    }

    override suspend fun getReports(
        isResolved: Boolean?,
        accountId: String?,
        targetAccountId: String?
    ): List<AdminReport> {
        return client.request("/api/v1/admin/reports") {
            method = HttpMethod.Get
            parameter("resolved", isResolved)
            parameter("account_id", accountId)
            parameter("target_account_id", targetAccountId)
        }
    }

    override suspend fun getReport(reportId: String): AdminReport {
        return client.request("/api/v1/admin/reports/${reportId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun assignReportToSelf(reportId: String): AdminReport {
        return client.request("/api/v1/admin/reports/${reportId.trim()}/assign_to_self") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unassignReport(reportId: String): AdminReport {
        return client.request("/api/v1/admin/reports/${reportId.trim()}/unassign") {
            method = HttpMethod.Post
        }
    }

    override suspend fun resolveReport(reportId: String): AdminReport {
        return client.request("/api/v1/admin/reports/${reportId.trim()}/resolve") {
            method = HttpMethod.Post
        }
    }

    override suspend fun reopenReport(reportId: String): AdminReport {
        return client.request("/api/v1/admin/reports/${reportId.trim()}/reopen") {
            method = HttpMethod.Post
        }
    }
}
