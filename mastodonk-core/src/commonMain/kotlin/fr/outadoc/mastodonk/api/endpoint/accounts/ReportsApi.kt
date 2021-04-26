package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.request.accounts.ReportCreate

public interface ReportsApi {

    public suspend fun fileReport(report: ReportCreate): Report
}
