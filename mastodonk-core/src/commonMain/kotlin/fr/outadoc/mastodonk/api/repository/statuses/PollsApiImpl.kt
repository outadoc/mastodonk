package fr.outadoc.mastodonk.api.repository.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.PollsApi
import fr.outadoc.mastodonk.api.entity.Poll
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class PollsApiImpl(private val client: MastodonHttpClient) : PollsApi {

    override suspend fun getPoll(pollId: String): Poll? {
        return client.requestOrNull("/api/v1/polls/${pollId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun addVote(pollId: String, choices: List<Int>): Poll {
        return client.request("/api/v1/statuses") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            formData {
                choices.forEach { append("choices", it) }
            }
        }
    }
}
