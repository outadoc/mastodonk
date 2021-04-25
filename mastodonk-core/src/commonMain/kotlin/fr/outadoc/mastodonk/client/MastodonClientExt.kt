package fr.outadoc.mastodonk.client

public fun MastodonClient(builderAction: MastodonClientBuilder.() -> Unit): MastodonClient {
    return MastodonClientBuilder()
        .apply(builderAction)
        .build()
}