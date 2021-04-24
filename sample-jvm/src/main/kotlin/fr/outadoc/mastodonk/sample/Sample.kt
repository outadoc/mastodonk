package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.client.MastodonClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = MastodonClient.Builder()
        .baseUrl("https://mastodon.social")
        .build()

    GlobalScope.launch {
        val timeline = client.timelines.getPublicTimeline()
        println(timeline)
    }.join()
}