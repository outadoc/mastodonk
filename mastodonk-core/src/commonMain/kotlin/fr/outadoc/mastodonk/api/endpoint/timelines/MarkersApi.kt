package fr.outadoc.mastodonk.api.endpoint.timelines

import fr.outadoc.mastodonk.api.entity.Marker
import fr.outadoc.mastodonk.api.entity.request.timelines.MarkerCreate

public interface MarkersApi {

    public suspend fun getSavedPosition(markers: List<String>): Marker

    public suspend fun savePosition(marker: MarkerCreate): Marker
}
