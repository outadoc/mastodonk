package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Report
import fr.outadoc.mastodonk.api.v1.entity.request.accounts.ReportCreate

public interface ReportsApi {

    public suspend fun fileReport(report: ReportCreate): Report
}
