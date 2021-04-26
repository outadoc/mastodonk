package fr.outadoc.mastodonk.api.v1.repository.instance

import fr.outadoc.mastodonk.api.v1.endpoint.instance.CustomEmojiApi
import fr.outadoc.mastodonk.api.v1.entity.Emoji
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class CustomEmojiApiImpl(private val client: MastodonHttpClient) : CustomEmojiApi {

    override suspend fun getCustomEmoji(): List<Emoji> {
        return client.request("/api/v1/custom_emojis") {
            method = HttpMethod.Get
        }
    }
}
