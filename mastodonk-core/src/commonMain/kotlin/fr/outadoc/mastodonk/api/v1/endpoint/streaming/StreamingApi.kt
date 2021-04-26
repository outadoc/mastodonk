package fr.outadoc.mastodonk.api.v1.endpoint.streaming

import fr.outadoc.mastodonk.api.v1.entity.streaming.StreamingEvent
import kotlinx.coroutines.flow.Flow

public interface StreamingApi {

    public suspend fun getUserStream(): Flow<StreamingEvent>

    public suspend fun getPublicStream(): Flow<StreamingEvent>

    public suspend fun getPublicLocalStream(): Flow<StreamingEvent>

    public suspend fun getHashtagStream(tag: String): Flow<StreamingEvent>

    public suspend fun getHashtagLocalStream(tag: String): Flow<StreamingEvent>

    public suspend fun getListStream(list: String): Flow<StreamingEvent>

    public suspend fun getDirectStream(): Flow<StreamingEvent>
}
