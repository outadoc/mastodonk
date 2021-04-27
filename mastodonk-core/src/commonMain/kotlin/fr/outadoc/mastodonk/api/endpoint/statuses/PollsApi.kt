package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.Poll

/**
 * View and vote on polls.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/polls/)
 */
public interface PollsApi {

    /**
     * Gets a single [Poll]'s details.
     */
    public suspend fun getPoll(id: String): Poll

    /**
     * Votes on a poll for the given [choices].
     */
    public suspend fun addVote(id: String, choices: List<Int>): Poll
}
