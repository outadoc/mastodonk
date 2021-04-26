package fr.outadoc.mastodonk.api.v1.endpoint.notifications

import fr.outadoc.mastodonk.api.v1.entity.PushSubscription
import fr.outadoc.mastodonk.api.v1.entity.request.notifications.PushSubscribe
import fr.outadoc.mastodonk.api.v1.entity.request.notifications.PushUpdate

public interface PushApi {

    public suspend fun subscribe(params: PushSubscribe): PushSubscription

    public suspend fun getSubscription(): PushSubscription

    public suspend fun updateSubscription(params: PushUpdate): PushSubscription

    public suspend fun deleteSubscription()
}
