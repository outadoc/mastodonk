package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.ReportsApi
import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.request.ReportCreate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class ReportsApiImpl(private val client: MastodonHttpClient) : ReportsApi {

    override suspend fun fileReport(report: ReportCreate): Report {
        return client.request("/api/v1/reports") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = report
        }
    }
}
