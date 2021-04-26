package fr.outadoc.mastodonk.api.endpoint.accounts

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Relationship

public interface FollowRequestsApi {

    public suspend fun getPendingFollows(limit: String?): List<Account>

    public suspend fun acceptFollow(id: String): Relationship

    public suspend fun rejectFollow(id: String): Relationship
}
