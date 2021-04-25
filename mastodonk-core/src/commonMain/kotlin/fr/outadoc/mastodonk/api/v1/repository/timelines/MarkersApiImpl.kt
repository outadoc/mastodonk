package fr.outadoc.mastodonk.api.v1.repository.timelines

import fr.outadoc.mastodonk.api.v1.endpoint.timelines.MarkersApi
import fr.outadoc.mastodonk.api.v1.entity.Marker
import fr.outadoc.mastodonk.api.v1.request.PartialMarker
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class MarkersApiImpl(private val client: MastodonHttpClient) : MarkersApi {

    override suspend fun getSavedPosition(markers: List<String>): Marker {
        return client.request("/api/v1/markers") {
            method = HttpMethod.Get
            parameter("timeline", markers)
        }
    }

    override suspend fun savePosition(marker: PartialMarker): Marker {
        return client.request("/api/v1/markers") {
            method = HttpMethod.Get
            body = marker
        }
    }
}