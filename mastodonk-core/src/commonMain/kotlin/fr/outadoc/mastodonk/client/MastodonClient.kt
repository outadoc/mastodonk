package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.BookmarksApi
import fr.outadoc.mastodonk.api.v1.endpoint.apps.AppsApi
import fr.outadoc.mastodonk.api.v1.endpoint.apps.OAuthApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.InstanceApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.TrendsApi
import fr.outadoc.mastodonk.api.v1.endpoint.statuses.StatusesApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.ConversationsApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.ListsApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.MarkersApi
import fr.outadoc.mastodonk.api.v1.endpoint.timelines.TimelinesApi

public interface MastodonClient {

    // region Timelines

    public val timelines: TimelinesApi
    public val conversations: ConversationsApi
    public val lists: ListsApi
    public val markers: MarkersApi

    // endregion

    // region Instance

    public val instance: InstanceApi
    public val trends: TrendsApi

    // endregion

    // region Accounts

    public val accounts: AccountsApi
    public val bookmarks: BookmarksApi

    // endregion

    // region Statuses

    public val statuses: StatusesApi

    // endregion

    // region Apps

    public val apps: AppsApi
    public val oauth: OAuthApi

    // endregion
}
