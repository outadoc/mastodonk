package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.Poll

public interface PollsApi {

    public suspend fun getPoll(id: String): Poll

    public suspend fun addVote(id: String, choices: List<Int>): Poll
}
