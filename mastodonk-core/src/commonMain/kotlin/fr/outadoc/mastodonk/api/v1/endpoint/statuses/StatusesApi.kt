package fr.outadoc.mastodonk.api.v1.endpoint.statuses

import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.Context
import fr.outadoc.mastodonk.api.v1.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.api.v1.entity.Visibility
import fr.outadoc.mastodonk.api.v1.entity.request.statuses.ScheduledStatusCreate
import fr.outadoc.mastodonk.api.v1.entity.request.statuses.StatusCreate
import fr.outadoc.mastodonk.client.MastodonEndpoint

public interface StatusesApi : MastodonEndpoint {

    public suspend fun postStatus(status: StatusCreate): Status

    public suspend fun postStatus(status: ScheduledStatusCreate): ScheduledStatus

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
