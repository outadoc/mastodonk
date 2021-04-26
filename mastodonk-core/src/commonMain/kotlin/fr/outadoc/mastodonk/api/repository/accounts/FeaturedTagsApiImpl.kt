package fr.outadoc.mastodonk.api.repository.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.FeaturedTagsApi
import fr.outadoc.mastodonk.api.entity.FeaturedTag
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class FeaturedTagsApiImpl(private val client: MastodonHttpClient) : FeaturedTagsApi {

    override suspend fun getFeaturedTags(): List<FeaturedTag> {
        return client.request("/api/v1/featured_tags") {
            method = HttpMethod.Get
        }
    }

    override suspend fun suggestedTags(): List<Tag> {
        return client.request("/api/v1/featured_tags/suggestions") {
            method = HttpMethod.Get
        }
    }

    override suspend fun featureTag(name: String): FeaturedTag {
        return client.request("/api/v1/featured_tags") {
            method = HttpMethod.Post
            formData {
                append("name", name)
            }
        }
    }

    override suspend fun unfeatureTag(id: String) {
        return client.request("/api/v1/featured_tags/${id.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
