package fr.outadoc.mastodonk.api.endpoint.announcements

import fr.outadoc.mastodonk.api.entity.Announcement

/**
 * View and manage instance-wide announcements.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/announcements/)
 */
public interface AnnouncementsApi {

    /**
     * See all currently active announcements set by admins.
     *
     * @param withDismissed Whether to include dismissed announcements.
     */
    public suspend fun getAnnouncements(withDismissed: Boolean? = null): List<Announcement>

    /**
     * Dismisses an announcement.
     */
    public suspend fun dismissAnnouncement(announcementId: String)

    /**
     * Adds a reaction to an announcement.
     *
     * @param name Unicode emoji, or shortcode of custom emoji.
     */
    public suspend fun addReaction(announcementId: String, name: String)

    /**
     * Removes a reaction to an announcement.
     *
     * @param name Unicode emoji, or shortcode of custom emoji.
     */
    public suspend fun removeReaction(announcementId: String, name: String)
}
