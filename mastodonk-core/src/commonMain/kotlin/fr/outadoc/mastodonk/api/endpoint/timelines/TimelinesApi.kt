package fr.outadoc.mastodonk.api.endpoint.timelines

import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * Read and view timelines of statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/timelines/)
 */
public interface TimelinesApi {

    /**
     * Gets the public timeline.
     */
    public suspend fun getPublicTimeline(
        onlyLocal: Boolean? = null,
        onlyRemote: Boolean? = null,
        onlyMedia: Boolean? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>

    /**
     * Gets the timeline for the given [hashtag].
     */
    public suspend fun getHashtagTimeline(
        hashtag: String,
        onlyLocal: Boolean? = null,
        onlyMedia: Boolean? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>

    /**
     * Gets the current user's home timeline.
     */
    public suspend fun getHomeTimeline(onlyLocal: Boolean? = null, pageInfo: PageInfo? = null): Page<List<Status>>

    /**
     * Gets the timeline for the given list.
     */
    public suspend fun getList(listId: String, pageInfo: PageInfo? = null): Page<List<Status>>?
}
