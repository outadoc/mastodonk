package fr.outadoc.mastodonk.api.v1.endpoint

import fr.outadoc.mastodonk.client.MastodonEndpoint
import fr.outadoc.mastodonk.api.v1.entity.*
import fr.outadoc.mastodonk.api.v1.request.PartialPoll
import kotlinx.datetime.Instant

public interface StatusesApi : MastodonEndpoint {

    public suspend fun postStatus(
        status: String? = null,
        mediaIds: List<String>? = null,
        poll: PartialPoll? = null,
        inReplyToId: String? = null,
        isSensitive: Boolean? = null,
        spoilerText: String? = null,
        visibility: Visibility? = null,
        language: String? = null
    ): Status

    public suspend fun scheduleStatus(
        scheduledAt: Instant,
        status: String? = null,
        mediaIds: List<String>? = null,
        poll: PartialPoll? = null,
        inReplyToId: String? = null,
        isSensitive: Boolean? = null,
        spoilerText: String? = null,
        visibility: Visibility? = null,
        language: String? = null
    ): ScheduledStatus

    public suspend fun getStatus(id: String): Status

    public suspend fun deleteStatus(id: String): Status

    public suspend fun getContext(id: String): Context

    public suspend fun getBoostedBy(id: String): List<Account>

    public suspend fun getFavouritedBy(id: String): List<Account>

    public suspend fun favourite(id: String): Status

    public suspend fun undoFavourite(id: String): Status

    public suspend fun boost(id: String, visibility: Visibility? = null): Status

    public suspend fun undoBoost(id: String): Status

    public suspend fun bookmark(id: String): Status

    public suspend fun undoBookmark(id: String): Status

    public suspend fun mute(id: String): Status

    public suspend fun undoMute(id: String): Status

    public suspend fun pin(id: String): Status

    public suspend fun undoPin(id: String): Status
}