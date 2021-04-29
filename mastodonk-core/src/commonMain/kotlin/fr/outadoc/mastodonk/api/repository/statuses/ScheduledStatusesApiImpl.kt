package fr.outadoc.mastodonk.api.repository.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class ScheduledStatusesApiImpl(private val client: MastodonHttpClient) : ScheduledStatusesApi {

    override suspend fun getScheduledStatuses(pageInfo: PageInfo?): Page<List<ScheduledStatus>> {
        return client.requestPage("/api/v1/scheduled_statuses") {
            method = HttpMethod.Get
            parameter(pageInfo)
        }
    }

    override suspend fun getScheduledStatus(statusId: String): ScheduledStatus? {
        return client.requestOrNull("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateScheduledStatus(statusId: String, scheduledAt: Instant?): ScheduledStatus {
        return client.request("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Put
            formData {
                scheduledAt?.let { append("scheduled_at", Json.encodeToString(it)) }
            }
        }
    }

    override suspend fun cancelScheduledStatus(statusId: String) {
        return client.request("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
