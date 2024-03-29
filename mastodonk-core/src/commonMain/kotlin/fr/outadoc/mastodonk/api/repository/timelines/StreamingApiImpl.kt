package fr.outadoc.mastodonk.api.repository.timelines

import fr.outadoc.mastodonk.api.endpoint.timelines.StreamingApi
import fr.outadoc.mastodonk.api.entity.streaming.StreamingEvent
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow

internal class StreamingApiImpl(private val client: MastodonHttpClient) : StreamingApi {

    private suspend fun getStream(
        stream: String,
        builder: HttpRequestBuilder.() -> Unit = {}
    ): Flow<StreamingEvent> {
        return client.getStream("/api/v1/streaming") {
            parameter("stream", stream)
            builder()
        }
    }

    override suspend fun getHomeStream(): Flow<StreamingEvent> {
        return getStream("user")
    }

    override suspend fun getPublicStream(): Flow<StreamingEvent> {
        return getStream("public")
    }

    override suspend fun getPublicLocalStream(): Flow<StreamingEvent> {
        return getStream("public:local")
    }

    override suspend fun getHashtagStream(tag: String): Flow<StreamingEvent> {
        return getStream("hashtag") {
            parameter("tag", tag)
        }
    }

    override suspend fun getHashtagLocalStream(tag: String): Flow<StreamingEvent> {
        return getStream("hashtag:local") {
            parameter("tag", tag)
        }
    }

    override suspend fun getListStream(listId: String): Flow<StreamingEvent> {
        return getStream("list") {
            parameter("list", listId)
        }
    }

    override suspend fun getDirectMessageStream(): Flow<StreamingEvent> {
        return getStream("direct")
    }
}
