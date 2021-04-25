package fr.outadoc.mastodonk.api.v1.endpoint.timelines

import fr.outadoc.mastodonk.api.v1.entity.Marker
import fr.outadoc.mastodonk.api.v1.entity.request.timelines.MarkerCreate
import fr.outadoc.mastodonk.client.MastodonEndpoint

public interface MarkersApi : MastodonEndpoint {

    public suspend fun getSavedPosition(markers: List<String>): Marker

    public suspend fun savePosition(marker: MarkerCreate): Marker
}