package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.api.v1.entity.Status
import fr.outadoc.mastodonk.client.MastodonClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = MastodonClient.Builder()
        .baseUrl("https://mastodon.social")
        .build()

    GlobalScope.launch {
        client.timelines.getPublicTimeline().print("timeline")
        client.timelines.getHashtagTimeline("cats").print("cats")
    }.join()
}

private fun List<Status>.print(tag: String) {
    println("got $size toots for $tag!")
    println("here are the first 3:")
    take(3).forEach { status ->
        println(status)
    }
    println()
}
