package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.api.v1.endpoint.TimelinesApi
import fr.outadoc.mastodonk.client.MastodonClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Sample {

    fun main() {
        val client = MastodonClient.Builder().build()
        val timelinesApi = client.getEndpoint<TimelinesApi>()

        GlobalScope.launch {
            val timeline = timelinesApi.getPublicTimeline()
            println(timeline)
        }
    }
}
