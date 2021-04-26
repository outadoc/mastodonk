package fr.outadoc.mastodonk.api.endpoint.proofs

public interface ProofsApi {

    public suspend fun getProofs(provider: String? = null, username: String? = null): String
}
