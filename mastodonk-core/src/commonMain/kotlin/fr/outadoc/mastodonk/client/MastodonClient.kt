package fr.outadoc.mastodonk.client

public interface MastodonClient {

    public fun <T : MastodonEndpoint> getEndpoint(): T

    public class Builder {

        public fun build(): MastodonClient {
            return MastodonClientImpl()
        }
    }
}
