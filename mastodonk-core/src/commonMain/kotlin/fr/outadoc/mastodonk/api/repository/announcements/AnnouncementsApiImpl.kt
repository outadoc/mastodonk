package fr.outadoc.mastodonk.api.repository.announcements

import fr.outadoc.mastodonk.api.endpoint.announcements.AnnouncementsApi
import fr.outadoc.mastodonk.api.entity.Announcement
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class AnnouncementsApiImpl(private val client: MastodonHttpClient) : AnnouncementsApi {

    override suspend fun getAllAnnouncements(withDismissed: Boolean?): List<Announcement> {
        return client.request("/api/v1/announcements") {
            method = HttpMethod.Get
        }
    }

    override suspend fun dismissAnnouncement(id: String) {
        return client.request("/api/v1/announcements/${id.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }

    override suspend fun addReaction(id: String, name: String) {
        return client.request("/api/v1/announcements/${id.trim()}/reactions/${name.trim()}") {
            method = HttpMethod.Put
        }
    }

    override suspend fun removeReaction(id: String, name: String) {
        return client.request("/api/v1/announcements/${id.trim()}/reactions/${name.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
