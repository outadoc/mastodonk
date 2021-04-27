package fr.outadoc.mastodonk.api.endpoint.proofs

/**
 * View identity proofs, for use by identity providers.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/proofs/)
 */
public interface ProofsApi {

    /**
     * View identity proofs.
     *
     * @param provider The identity provider to be looked up.
     * Currently only supports `keybase` (case-sensitive).
     * @param username The username on the selected identity provider.
     */
    public suspend fun getProofs(provider: String? = null, username: String? = null): String
}
