package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Status

public interface MutesApi {

    public suspend fun getMutes(maxId: String?, limit: Int?, minId: String?): List<Status>
}