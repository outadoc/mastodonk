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
    public suspend fun getPoll(pollId: String): Poll?

    /**
     * Votes on a poll for the given [choices].
     */
    public suspend fun addVote(pollId: String, choices: List<Int>): Poll
}
