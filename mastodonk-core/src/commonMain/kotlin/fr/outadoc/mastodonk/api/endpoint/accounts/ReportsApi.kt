package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.request.ReportCreate

/**
 * Create user reports.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/reports/)
 */
public interface ReportsApi {

    /**
     * File a [Report].
     */
    public suspend fun fileReport(report: ReportCreate): Report
}
