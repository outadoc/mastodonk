package fr.outadoc.mastodonk.api.endpoint.instance

import fr.outadoc.mastodonk.api.entity.Activity
import fr.outadoc.mastodonk.api.entity.Instance

public interface InstanceApi {

    public suspend fun getInstance(): Instance

    public suspend fun getPeers(): List<String>

    public suspend fun getActivity(): List<Activity>
}
