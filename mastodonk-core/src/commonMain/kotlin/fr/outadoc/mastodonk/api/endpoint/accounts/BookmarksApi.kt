package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Status

public interface BookmarksApi {

    public suspend fun getBookmarks(maxId: String?, sinceId: String?, limit: Int?, minId: String?): List<Status>
}
