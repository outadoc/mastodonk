package fr.outadoc.mastodonk.api.v1.endpoint.instance

import fr.outadoc.mastodonk.api.v1.entity.Activity
import fr.outadoc.mastodonk.api.v1.entity.Instance

public interface InstanceApi {

    public suspend fun getInstance(): Instance

    public suspend fun getPeers(): List<String>

    public suspend fun getActivity(): List<Activity>
}
