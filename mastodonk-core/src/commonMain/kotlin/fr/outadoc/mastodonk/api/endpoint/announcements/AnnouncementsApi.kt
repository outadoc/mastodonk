package fr.outadoc.mastodonk.api.endpoint.announcements

import fr.outadoc.mastodonk.api.entity.Announcement

public interface AnnouncementsApi {

    public suspend fun getAllAnnouncements(withDismissed: Boolean? = null): List<Announcement>

    public suspend fun dismissAnnouncement(id: String)

    public suspend fun addReaction(id: String, name: String)

    public suspend fun removeReaction(id: String, name: String)
}
