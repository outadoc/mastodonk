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

    override suspend fun getAccount(id: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${id.trim()}") {
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

    override suspend fun approvePendingAccount(id: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${id.trim()}/approve") {
            method = HttpMethod.Post
        }
    }

    override suspend fun rejectPendingAccount(id: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${id.trim()}/reject") {
            method = HttpMethod.Post
        }
    }

    override suspend fun reenableAccount(id: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${id.trim()}/enable") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unsilenceAccount(id: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${id.trim()}/unsilence") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unsuspendAccount(id: String): AdminAccount {
        return client.request("/api/v1/admin/accounts/${id.trim()}/unsuspend") {
            method = HttpMethod.Post
        }
    }

    override suspend fun getAllReports(
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

    override suspend fun getReport(id: String): AdminReport {
        return client.request("/api/v1/admin/reports/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun assignReportToSelf(id: String): AdminReport {
        return client.request("/api/v1/admin/reports/${id.trim()}/assign_to_self") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unassignReport(id: String): AdminReport {
        return client.request("/api/v1/admin/reports/${id.trim()}/unassign") {
            method = HttpMethod.Post
        }
    }

    override suspend fun resolveReport(id: String): AdminReport {
        return client.request("/api/v1/admin/reports/${id.trim()}/resolve") {
            method = HttpMethod.Post
        }
    }

    override suspend fun reopenReport(id: String): AdminReport {
        return client.request("/api/v1/admin/reports/${id.trim()}/reopen") {
            method = HttpMethod.Post
        }
    }
}
