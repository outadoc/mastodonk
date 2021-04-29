package fr.outadoc.mastodonk.api.repository.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.api.entity.request.ScheduledStatusUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

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
