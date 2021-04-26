package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.endpoint.accounts.AccountsApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.BlocksApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.BookmarksApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.DomainBlocksApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.EndorsementsApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.FavouritesApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.FeaturedTagsApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.FiltersApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.FollowRequestsApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.MutesApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.PreferencesApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.ReportsApi
import fr.outadoc.mastodonk.api.v1.endpoint.accounts.SuggestionsApi
import fr.outadoc.mastodonk.api.v1.endpoint.announcements.AnnouncementsApi
import fr.outadoc.mastodonk.api.v1.endpoint.apps.AppsApi
import fr.outadoc.mastodonk.api.v1.endpoint.apps.OAuthApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.CustomEmojiApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.DirectoryApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.InstanceApi
import fr.outadoc.mastodonk.api.v1.endpoint.instance.TrendsApi
import fr.outadoc.mastodonk.api.v1.endpoint.notifications.NotificationsApi
import fr.outadoc.mastodonk.api.v1.endpoint.notifications.PushApi
import fr.outadoc.mastodonk.api.v1.endpoint.search.SearchApi
import fr.outadoc.mastodonk.api.v1.endpoint.statuses.MediaApi
import fr.outadoc.mastodonk.api.v1.endpoint.statuses.PollsApi
import fr.outadoc.mastodonk.api.v1.endpoint.statuses.ScheduledStatusesApi
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
    public val directory: DirectoryApi
    public val customEmoji: CustomEmojiApi

    // endregion

    // region Accounts

    public val accounts: AccountsApi
    public val bookmarks: BookmarksApi
    public val favourites: FavouritesApi
    public val mutes: MutesApi
    public val blocks: BlocksApi
    public val domainBlocks: DomainBlocksApi
    public val filters: FiltersApi
    public val reports: ReportsApi
    public val followRequests: FollowRequestsApi
    public val endorsements: EndorsementsApi
    public val featuredTags: FeaturedTagsApi
    public val preferences: PreferencesApi
    public val suggestions: SuggestionsApi

    // endregion

    // region Statuses

    public val statuses: StatusesApi
    public val media: MediaApi
    public val polls: PollsApi
    public val scheduledStatuses: ScheduledStatusesApi

    // endregion

    // region Notifications

    public val notifications: NotificationsApi
    public val push: PushApi

    // endregion

    // region Apps

    public val apps: AppsApi
    public val oauth: OAuthApi

    // endregion

    // region Search

    public val search: SearchApi

    // endregion

    // region Announcements

    public val announcements: AnnouncementsApi

    // endregion
}
