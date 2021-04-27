package fr.outadoc.mastodonk.api.endpoint.timelines

import fr.outadoc.mastodonk.api.entity.Marker
import fr.outadoc.mastodonk.api.entity.request.timelines.MarkerCreate

/**
 * Save and restore your position in timelines.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/timelines/markers/)
 */
public interface MarkersApi {

    /**
     * Gets the saved timeline position for the given marker types.
     *
     * @param markers The given markers to fetch. "home" or "notifications"
     */
    public suspend fun getSavedPosition(markers: List<String>): Marker

    /**
     * Saves the current position in the timeline.
     */
    public suspend fun savePosition(marker: MarkerCreate): Marker
}
