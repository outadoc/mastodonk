package fr.outadoc.mastodonk.api.repository.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.StatusesApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Context
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Visibility
import fr.outadoc.mastodonk.api.entity.request.statuses.ReblogParams
import fr.outadoc.mastodonk.api.entity.request.statuses.ScheduledStatusCreate
import fr.outadoc.mastodonk.api.entity.request.statuses.StatusCreate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class StatusesApiImpl(private val client: MastodonHttpClient) : StatusesApi {

    override suspend fun postStatus(status: StatusCreate): Status {
        return client.request("/api/v1/statuses") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = status
        }
    }

    override suspend fun postStatus(status: ScheduledStatusCreate): ScheduledStatus {
        return client.request("/api/v1/statuses") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = status
        }
    }

    override suspend fun getStatus(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun deleteStatus(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun getContext(statusId: String): Context {
        return client.request("/api/v1/statuses/${statusId.trim()}/context") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getBoostedBy(statusId: String): List<Account> {
        return client.request("/api/v1/statuses/${statusId.trim()}/reblogged_by") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getFavouritedBy(statusId: String): List<Account> {
        return client.request("/api/v1/statuses/${statusId.trim()}/favourited_by") {
            method = HttpMethod.Get
        }
    }

    override suspend fun favourite(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/favourite") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoFavourite(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/unfavourite") {
            method = HttpMethod.Post
        }
    }

    override suspend fun boost(statusId: String, visibility: Visibility?): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/reblog") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = ReblogParams(visibility = visibility)
        }
    }

    override suspend fun undoBoost(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/unreblog") {
            method = HttpMethod.Post
        }
    }

    override suspend fun bookmark(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/bookmark") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoBookmark(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/unbookmark") {
            method = HttpMethod.Post
        }
    }

    override suspend fun mute(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/mute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoMute(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/unmute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun featureStatus(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/pin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unfeatureStatus(statusId: String): Status {
        return client.request("/api/v1/statuses/${statusId.trim()}/unpin") {
            method = HttpMethod.Post
        }
    }
}
