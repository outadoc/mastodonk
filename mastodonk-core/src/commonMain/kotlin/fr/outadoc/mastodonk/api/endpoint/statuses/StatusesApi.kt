package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Context
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Visibility
import fr.outadoc.mastodonk.api.entity.request.statuses.ScheduledStatusCreate
import fr.outadoc.mastodonk.api.entity.request.statuses.StatusCreate

/**
 * Publish, interact, and view information about statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/)
 */
public interface StatusesApi {

    /**
     * Posts a new status.
     */
    public suspend fun postStatus(status: StatusCreate): Status

    /**
     * Schedules a new status to be posted in the future.
     */
    public suspend fun postStatus(status: ScheduledStatusCreate): ScheduledStatus

    /**
     * Gets information about a status.
     */
    public suspend fun getStatus(statusId: String): Status

    /**
     * Deletes a status.
     */
    public suspend fun deleteStatus(statusId: String): Status

    /**
     * Gets statuses above and below this status in the thread.
     */
    public suspend fun getContext(statusId: String): Context

    /**
     * Gets who boosted a given status.
     */
    public suspend fun getBoostedBy(statusId: String): List<Account>

    /**
     * Gets who favourited a given status.
     */
    public suspend fun getFavouritedBy(statusId: String): List<Account>

    /**
     * Adds a status to your favourites list.
     */
    public suspend fun favourite(statusId: String): Status

    /**
     * Removes a status from your favourites list.
     */
    public suspend fun undoFavourite(statusId: String): Status

    /**
     * Boosts a status.
     */
    public suspend fun boost(statusId: String, visibility: Visibility? = null): Status

    /**
     * Un-boosts a status.
     */
    public suspend fun undoBoost(statusId: String): Status

    /**
     * Privately bookmarks a status.
     */
    public suspend fun bookmark(statusId: String): Status

    /**
     * Removes a status from the account's private bookmarks.
     */
    public suspend fun undoBookmark(statusId: String): Status

    /**
     * Turns off notifications for the thread that this status is part of.
     *
     * Must be a thread in which the current account is a participant.
     */
    public suspend fun mute(statusId: String): Status

    /**
     * Un-mutes notifications for the thread that this status is part of.
     */
    public suspend fun undoMute(statusId: String): Status

    /**
     * Features a status from the current account at the top of their profile.
     */
    public suspend fun featureStatus(statusId: String): Status

    /**
     * Un-features a currently featured status.
     */
    public suspend fun unfeatureStatus(statusId: String): Status
}
