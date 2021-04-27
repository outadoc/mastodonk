package fr.outadoc.mastodonk.api.endpoint.timelines

import fr.outadoc.mastodonk.api.entity.streaming.StreamingEvent
import kotlinx.coroutines.flow.Flow

/**
 * Listen to new statuses in real-time with the WebSockets API.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/timelines/streaming/)
 */
public interface StreamingApi {

    /**
     * Gets a real-time stream of new statuses on the user's home timeline.
     */
    public suspend fun getUserStream(): Flow<StreamingEvent>

    /**
     * Gets a real-time stream of new statuses on the federated public timeline.
     */
    public suspend fun getPublicStream(): Flow<StreamingEvent>

    /**
     * Gets a real-time stream of new statuses on the instance's local timeline.
     */
    public suspend fun getPublicLocalStream(): Flow<StreamingEvent>

    /**
     * Gets a real-time stream of new statuses on the federated timeline for the given [tag].
     */
    public suspend fun getHashtagStream(tag: String): Flow<StreamingEvent>

    /**
     * Gets a real-time stream of new statuses on the instance's local timeline for the given [tag].
     */
    public suspend fun getHashtagLocalStream(tag: String): Flow<StreamingEvent>

    /**
     * Gets a real-time stream of new statuses for the given list.
     */
    public suspend fun getListStream(listId: String): Flow<StreamingEvent>

    /**
     * Gets a real-time stream of all direct messages.
     */
    public suspend fun getDirectMessageStream(): Flow<StreamingEvent>
}
