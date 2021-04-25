package fr.outadoc.mastodonk.api.v1.endpoint.accounts

import fr.outadoc.mastodonk.api.v1.entity.FeaturedTag
import fr.outadoc.mastodonk.api.v1.entity.Tag

public interface FeaturedTagsApi {

    public suspend fun getFeaturedTags(): List<FeaturedTag>

    public suspend fun suggestedTags(): List<Tag>

    public suspend fun featureTag(name: String): FeaturedTag

    public suspend fun unfeatureTag(id: String)
}
