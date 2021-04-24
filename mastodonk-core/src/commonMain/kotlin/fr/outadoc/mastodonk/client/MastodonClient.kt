package fr.outadoc.mastodonk.client

public interface MastodonClient {
    public fun <T : MastodonEndpoint> getEndpoint(): MastodonEndpoint
}
