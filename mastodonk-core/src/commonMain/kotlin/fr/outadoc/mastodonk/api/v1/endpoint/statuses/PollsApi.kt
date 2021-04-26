package fr.outadoc.mastodonk.api.v1.endpoint.statuses

import fr.outadoc.mastodonk.api.v1.entity.Poll

public interface PollsApi {

    public suspend fun getPoll(id: String): Poll

    public suspend fun addVote(id: String, choices: List<Int>): Poll
}
