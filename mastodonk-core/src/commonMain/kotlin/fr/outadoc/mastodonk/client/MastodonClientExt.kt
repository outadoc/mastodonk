package fr.outadoc.mastodonk.client

/**
 * Build a Mastodon API client.
 */
public fun MastodonClient(builderAction: MastodonClientBuilder.() -> Unit): MastodonClient {
    return MastodonClientBuilder()
        .apply(builderAction)
        .build()
}
