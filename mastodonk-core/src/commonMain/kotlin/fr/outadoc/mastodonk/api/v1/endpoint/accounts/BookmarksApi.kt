package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Status

public interface BookmarksApi {

    public suspend fun getBookmarks(maxId: String?, sinceId: String?, limit: Int?, minId: String?): List<Status>
}