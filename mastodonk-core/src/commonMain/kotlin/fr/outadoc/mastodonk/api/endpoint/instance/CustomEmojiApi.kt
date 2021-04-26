package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Emoji

public interface CustomEmojiApi {

    public suspend fun getCustomEmoji(): List<Emoji>
}
