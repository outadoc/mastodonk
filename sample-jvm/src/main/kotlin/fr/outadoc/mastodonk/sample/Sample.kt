package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.client.MastodonClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Sample {

    fun main() {
        val client = MastodonClient.Builder()
            .baseUrl("https://mastodon.example")
            .build()

        GlobalScope.launch {
            val timeline = client.timelines.getPublicTimeline()
            println(timeline)
        }
    }
}
