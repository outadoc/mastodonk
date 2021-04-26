package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.repository.accounts.AccountsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.BlocksApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.BookmarksApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.DomainBlocksApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.EndorsementsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.FavouritesApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.FeaturedTagsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.FiltersApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.FollowRequestsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.MutesApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.PreferencesApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.ReportsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.accounts.SuggestionsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.apps.AppsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.apps.OAuthApiImpl
import fr.outadoc.mastodonk.api.v1.repository.instance.DirectoryApiImpl
import fr.outadoc.mastodonk.api.v1.repository.instance.InstanceApiImpl
import fr.outadoc.mastodonk.api.v1.repository.instance.TrendsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.notifications.NotificationsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.notifications.PushApiImpl
import fr.outadoc.mastodonk.api.v1.repository.search.SearchApiImpl
import fr.outadoc.mastodonk.api.v1.repository.statuses.MediaApiImpl
import fr.outadoc.mastodonk.api.v1.repository.statuses.PollsApiImpl
import fr.outadoc.mastodonk.api.v1.repository.statuses.ScheduledStatusesApiImpl
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
    override val directory = DirectoryApiImpl(httpClient)

    override val accounts = AccountsApiImpl(httpClient)
    override val bookmarks = BookmarksApiImpl(httpClient)
    override val favourites = FavouritesApiImpl(httpClient)
    override val mutes = MutesApiImpl(httpClient)
    override val blocks = BlocksApiImpl(httpClient)
    override val domainBlocks = DomainBlocksApiImpl(httpClient)
    override val filters = FiltersApiImpl(httpClient)
    override val reports = ReportsApiImpl(httpClient)
    override val followRequests = FollowRequestsApiImpl(httpClient)
    override val endorsements = EndorsementsApiImpl(httpClient)
    override val featuredTags = FeaturedTagsApiImpl(httpClient)
    override val preferences = PreferencesApiImpl(httpClient)
    override val suggestions = SuggestionsApiImpl(httpClient)

    override val statuses = StatusesApiImpl(httpClient)
    override val media = MediaApiImpl(httpClient)
    override val polls = PollsApiImpl(httpClient)
    override val scheduledStatuses = ScheduledStatusesApiImpl(httpClient)

    override val notifications = NotificationsApiImpl(httpClient)
    override val push = PushApiImpl(httpClient)

    override val apps = AppsApiImpl(httpClient)
    override val oauth = OAuthApiImpl(httpClient)

    override val search = SearchApiImpl(httpClient)
}
