package fr.outadoc.mastodonk.api.v1.repository.statuses

import fr.outadoc.mastodonk.api.v1.endpoint.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.v1.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.v1.entity.request.statuses.ScheduledStatusUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class ScheduledStatusesApiImpl(private val client: MastodonHttpClient) : ScheduledStatusesApi {

    override suspend fun getScheduledStatuses(
        limit: Int?,
        maxId: String?,
        sinceId: String?,
        minId: String?
    ): List<ScheduledStatus> {
        return client.request("/api/v1/scheduled_statuses") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
        }
    }

    override suspend fun getScheduledStatus(id: String): ScheduledStatus {
        return client.request("/api/v1/scheduled_statuses/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateScheduledStatus(id: String, update: ScheduledStatusUpdate): ScheduledStatus {
        return client.request("/api/v1/scheduled_statuses/${id.trim()}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            body = update
        }
    }

    override suspend fun cancelSchedulesStatus(id: String): ScheduledStatus {
        return client.request("/api/v1/scheduled_statuses/${id.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
