package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.repository.accounts.AccountsApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.BlocksApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.BookmarksApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.DomainBlocksApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.EndorsementsApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.FavouritesApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.FeaturedTagsApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.FiltersApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.FollowRequestsApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.MutesApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.PreferencesApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.ReportsApiImpl
import fr.outadoc.mastodonk.api.repository.accounts.SuggestionsApiImpl
import fr.outadoc.mastodonk.api.repository.admin.AdminApiImpl
import fr.outadoc.mastodonk.api.repository.announcements.AnnouncementsApiImpl
import fr.outadoc.mastodonk.api.repository.apps.AppsApiImpl
import fr.outadoc.mastodonk.api.repository.apps.OAuthApiImpl
import fr.outadoc.mastodonk.api.repository.instance.CustomEmojiApiImpl
import fr.outadoc.mastodonk.api.repository.instance.DirectoryApiImpl
import fr.outadoc.mastodonk.api.repository.instance.InstanceApiImpl
import fr.outadoc.mastodonk.api.repository.instance.TrendsApiImpl
import fr.outadoc.mastodonk.api.repository.notifications.NotificationsApiImpl
import fr.outadoc.mastodonk.api.repository.notifications.PushApiImpl
import fr.outadoc.mastodonk.api.repository.proofs.ProofsApiImpl
import fr.outadoc.mastodonk.api.repository.search.SearchApiImpl
import fr.outadoc.mastodonk.api.repository.statuses.MediaApiImpl
import fr.outadoc.mastodonk.api.repository.statuses.PollsApiImpl
import fr.outadoc.mastodonk.api.repository.statuses.ScheduledStatusesApiImpl
import fr.outadoc.mastodonk.api.repository.statuses.StatusesApiImpl
import fr.outadoc.mastodonk.api.repository.timelines.ConversationsApiImpl
import fr.outadoc.mastodonk.api.repository.timelines.ListsApiImpl
import fr.outadoc.mastodonk.api.repository.timelines.MarkersApiImpl
import fr.outadoc.mastodonk.api.repository.timelines.StreamingApiImpl
import fr.outadoc.mastodonk.api.repository.timelines.TimelinesApiImpl

internal class MastodonClientImpl(httpClient: MastodonHttpClient) : MastodonClient {

    override val timelines = TimelinesApiImpl(httpClient)
    override val conversations = ConversationsApiImpl(httpClient)
    override val lists = ListsApiImpl(httpClient)
    override val markers = MarkersApiImpl(httpClient)
    override val streaming = StreamingApiImpl(httpClient)

    override val instance = InstanceApiImpl(httpClient)
    override val trends = TrendsApiImpl(httpClient)
    override val directory = DirectoryApiImpl(httpClient)
    override val customEmoji = CustomEmojiApiImpl(httpClient)

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

    override val announcements = AnnouncementsApiImpl(httpClient)

    override val proofs = ProofsApiImpl(httpClient)

    override val admin = AdminApiImpl(httpClient)
}
