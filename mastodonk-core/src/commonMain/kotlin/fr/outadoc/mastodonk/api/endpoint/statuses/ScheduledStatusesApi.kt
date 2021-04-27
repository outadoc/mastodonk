package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.request.statuses.ScheduledStatusUpdate

/**
 * View and manage currently scheduled statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/scheduled_statuses/)
 */
public interface ScheduledStatusesApi {

    /**
     * Gets currently scheduled statuses for this account.
     */
    public suspend fun getScheduledStatuses(
        limit: Int? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null
    ): List<ScheduledStatus>

    /**
     * Gets a single [ScheduledStatus].
     */
    public suspend fun getScheduledStatus(statusId: String): ScheduledStatus

    /**
     * Updates the schedule of a [ScheduledStatus].
     */
    public suspend fun updateScheduledStatus(statusId: String, update: ScheduledStatusUpdate): ScheduledStatus

    /**
     * Cancels a [ScheduledStatus].
     */
    public suspend fun cancelScheduledStatus(statusId: String): ScheduledStatus
}
