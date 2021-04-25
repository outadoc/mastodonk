package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.repository.accounts.AccountsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.BookmarksApiImpl
import fr.outadoc.mastodonk.api.v1.repository.apps.AppsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.apps.OAuthApiImpl
import fr.outadoc.mastodonk.api.v1.repository.instance.InstanceApiImpl
import fr.outadoc.mastodonk.api.v1.repository.instance.TrendsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.statuses.StatusesApiImpl
import fr.outadoc.mastodonk.api.v1.repository.timelines.ConversationsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.timelines.ListsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.timelines.MarkersApiImpl
import fr.outadoc.mastodonk.api.v1.repository.timelines.TimelinesApiImpl

internal class MastodonClientImpl(httpClient: MastodonHttpClient) : MastodonClient {

    override val timelines = TimelinesApiImpl(httpClient)
    override val conversations = ConversationsApiImpl(httpClient)
    override val lists = ListsApiImpl(httpClient)
    override val markers = MarkersApiImpl(httpClient)

    override val instance = InstanceApiImpl(httpClient)
    override val trends = TrendsApiImpl(httpClient)

    override val accounts = AccountsApiImpl(httpClient)
    override val bookmarks = BookmarksApiImpl(httpClient)

    override val statuses = StatusesApiImpl(httpClient)

    override val apps = AppsApiImpl(httpClient)
    override val oauth = OAuthApiImpl(httpClient)
}
