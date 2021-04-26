package fr.outadoc.mastodonk.api.v1.repository.statuses

import fr.outadoc.mastodonk.api.v1.endpoint.statuses.PollsApi
import fr.outadoc.mastodonk.api.v1.entity.Poll
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class PollsApiImpl(private val client: MastodonHttpClient) : PollsApi {

    override suspend fun getPoll(id: String): Poll {
        return client.request("/api/v1/polls/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun addVote(id: String, choices: List<Int>): Poll {
        return client.request("/api/v1/statuses") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            formData {
                choices.forEach { append("choices", it) }
            }
        }
    }
}
