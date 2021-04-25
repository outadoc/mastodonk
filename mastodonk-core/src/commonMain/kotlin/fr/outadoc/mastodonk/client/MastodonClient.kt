package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.instance.InstanceApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.TrendsApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.ConversationsApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.MarkersApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.TimelinesApi

public interface MastodonClient {

    // region Timeline

    public val timelines: TimelinesApi
    public val conversations: ConversationsApi
    public val lists: ListsApi
    public val markers: MarkersApi

    // endregion

    // region Instance

    public val instance: InstanceApi
    public val trends: TrendsApi

    // endregion
}
