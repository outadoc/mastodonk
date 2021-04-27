package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.request.accounts.ReportCreate

/**
 * Create user reports.
 *
 * @see [reports - Mastodon Documentation](https://docs.joinmastodon.org/methods/reports/)
 */
public interface ReportsApi {

    /**
     * File a [Report].
     */
    public suspend fun fileReport(report: ReportCreate): Report
}
