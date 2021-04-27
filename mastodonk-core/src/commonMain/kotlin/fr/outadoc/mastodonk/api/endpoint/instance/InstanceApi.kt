package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Activity
import fr.outadoc.mastodonk.api.entity.Instance

/**
 * Informational endpoint to discover information about a Mastodon instance.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/)
 */
public interface InstanceApi {

    /**
     * Gets information about the Mastodon instance.
     */
    public suspend fun getInstanceInfo(): Instance

    /**
     * Gets the list of domains that this instance is aware of.
     */
    public suspend fun getPeers(): List<String>

    /**
     * Gets the instance's activity over the last 3 months, binned weekly.
     */
    public suspend fun getActivity(): List<Activity>
}
