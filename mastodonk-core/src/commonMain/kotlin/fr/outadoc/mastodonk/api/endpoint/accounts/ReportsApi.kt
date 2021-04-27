package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.request.accounts.ReportCreate

/**
 * Create user reports.
 */
public interface ReportsApi {

    /**
     * File a [Report].
     */
    public suspend fun fileReport(report: ReportCreate): Report
}
