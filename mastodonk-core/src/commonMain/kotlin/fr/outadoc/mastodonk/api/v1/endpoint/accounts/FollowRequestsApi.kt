package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.Account
import fr.outadoc.mastodonk.api.v1.entity.Relationship

public interface FollowRequestsApi {

    public suspend fun getPendingFollows(limit: String?): List<Account>

    public suspend fun acceptFollow(id: String): Relationship

    public suspend fun rejectFollow(id: String): Relationship
}
