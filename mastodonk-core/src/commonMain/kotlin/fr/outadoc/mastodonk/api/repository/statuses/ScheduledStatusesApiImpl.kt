package fr.outadoc.mastodonk.api.repository.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.request.statuses.ScheduledStatusUpdate
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

    override suspend fun getScheduledStatus(statusId: String): ScheduledStatus? {
        return client.requestOrNull("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateScheduledStatus(statusId: String, update: ScheduledStatusUpdate): ScheduledStatus {
        return client.request("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            body = update
        }
    }

    override suspend fun cancelScheduledStatus(statusId: String) {
        return client.request("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
