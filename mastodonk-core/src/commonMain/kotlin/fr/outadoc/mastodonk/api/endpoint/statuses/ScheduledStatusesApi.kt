package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.request.statuses.ScheduledStatusUpdate

public interface ScheduledStatusesApi {

    public suspend fun getScheduledStatuses(
        limit: Int? = null,
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null
    ): List<ScheduledStatus>

    public suspend fun getScheduledStatus(id: String): ScheduledStatus

    public suspend fun updateScheduledStatus(id: String, update: ScheduledStatusUpdate): ScheduledStatus

    public suspend fun cancelSchedulesStatus(id: String): ScheduledStatus
}
