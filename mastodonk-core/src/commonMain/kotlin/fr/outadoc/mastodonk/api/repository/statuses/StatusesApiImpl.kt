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

    override suspend fun getStatus(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun deleteStatus(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun getContext(id: String): Context {
        return client.request("/api/v1/statuses/${id.trim()}/context") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getBoostedBy(id: String): List<Account> {
        return client.request("/api/v1/statuses/${id.trim()}/reblogged_by") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getFavouritedBy(id: String): List<Account> {
        return client.request("/api/v1/statuses/${id.trim()}/favourited_by") {
            method = HttpMethod.Get
        }
    }

    override suspend fun favourite(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/favourite") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoFavourite(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/unfavourite") {
            method = HttpMethod.Post
        }
    }

    override suspend fun boost(id: String, visibility: Visibility?): Status {
        return client.request("/api/v1/statuses/${id.trim()}/reblog") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            body = ReblogParams(visibility = visibility)
        }
    }

    override suspend fun undoBoost(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/unreblog") {
            method = HttpMethod.Post
        }
    }

    override suspend fun bookmark(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/bookmark") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoBookmark(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/unbookmark") {
            method = HttpMethod.Post
        }
    }

    override suspend fun mute(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/mute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoMute(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/unmute") {
            method = HttpMethod.Post
        }
    }

    override suspend fun pin(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/pin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun undoPin(id: String): Status {
        return client.request("/api/v1/statuses/${id.trim()}/unpin") {
            method = HttpMethod.Post
        }
    }
}
