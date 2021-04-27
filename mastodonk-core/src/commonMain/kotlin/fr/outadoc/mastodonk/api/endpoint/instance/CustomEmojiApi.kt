package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Emoji

/**
 * View custom emojis supported by the Mastodon instance.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/custom_emojis/)
 */
public interface CustomEmojiApi {

    /**
     * Gets the list of custom emojis available on the server.
     */
    public suspend fun getCustomEmoji(): List<Emoji>
}
