package fr.outadoc.mastodonk.api.v1.endpoint

import fr.outadoc.mastodonk.api.v1.entity.*
import fr.outadoc.mastodonk.api.v1.request.PartialPoll
import kotlinx.datetime.Instant

public interface StatusesApi {

    public suspend fun postStatus(
        status: String?,
        mediaIds: List<String>?,
        poll: PartialPoll?,
        inReplyToId: String?,
        isSensitive: Boolean?,
        spoilerText: String?,
        visibility: Visibility?,
        language: String?
    ): Status

    public suspend fun scheduleStatus(
        scheduledAt: Instant,
        status: String?,
        mediaIds: List<String>?,
        poll: PartialPoll?,
        inReplyToId: String?,
        isSensitive: Boolean?,
        spoilerText: String?,
        visibility: Visibility?,
        language: String?
    ): ScheduledStatus

    public suspend fun getStatus(id: String): Status

    public suspend fun deleteStatus(id: String): Status

    public suspend fun getContext(id: String): Context

    public suspend fun getBoostedBy(id: String): List<Account>

    public suspend fun getFavouritedBy(id: String): List<Account>

    public suspend fun favourite(id: String): Status

    public suspend fun undoFavourite(id: String): Status

    public suspend fun boost(id: String, visibility: Visibility?): Status

    public suspend fun undoBoost(id: String): Status

    public suspend fun bookmark(id: String): Status

    public suspend fun undoBookmark(id: String): Status

    public suspend fun mute(id: String): Status

    public suspend fun undoMute(id: String): Status

    public suspend fun pin(id: String): Status

    public suspend fun undoPin(id: String): Status
}