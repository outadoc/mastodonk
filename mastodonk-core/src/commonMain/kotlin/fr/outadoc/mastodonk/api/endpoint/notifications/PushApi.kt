package fr.outadoc.mastodonk.api.endpoint.notifications

import fr.outadoc.mastodonk.api.entity.PushSubscription
import fr.outadoc.mastodonk.api.entity.request.notifications.PushSubscribe
import fr.outadoc.mastodonk.api.entity.request.notifications.PushUpdate

/**
 * Subscribe to and receive push notifications when a server-side
 * notification is received, via the Web Push API.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/notifications/push/)
 */
public interface PushApi {

    /**
     * Adds a Web Push API subscription to receive notifications.
     *
     * Each access token can have one push subscription.
     * If you create a new subscription, the old subscription is deleted.
     */
    public suspend fun subscribe(params: PushSubscribe): PushSubscription

    /**
     * View the [PushSubscription] currently associated with this access token.
     */
    public suspend fun getSubscription(): PushSubscription

    /**
     * Updates the current push subscription.
     */
    public suspend fun updateSubscription(params: PushUpdate): PushSubscription

    /**
     * Removes the current Web Push API subscription.
     */
    public suspend fun deleteSubscription()
}
