package fr.outadoc.mastodonk.api.v1.endpoint.instance

import fr.outadoc.mastodonk.api.v1.entity.Emoji

public interface CustomEmojiApi {

    public suspend fun getCustomEmoji(): List<Emoji>
}
