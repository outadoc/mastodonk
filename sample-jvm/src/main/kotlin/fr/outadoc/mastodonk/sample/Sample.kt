package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.api.entity.streaming.UpdateEvent
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import fr.outadoc.mastodonk.client.MastodonClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    val client = MastodonClient {
        baseUrl = "https://mastodon.social"
        authTokenProvider = AuthTokenProvider {
            //AuthToken(accessToken = "your-access-token-here")
            null
        }
    }

    GlobalScope.launch {
        val instance = client.instance.getInstanceInfo()
        println("connected to instance ${instance.title} at ${instance.uri}!")
        println(instance)
        println()

        client.timelines.getPublicTimeline().also { timeline ->
            println(timeline)
            println()
        }

        client.timelines.getHashtagTimeline("cats").also { cats ->
            println("got ${cats.size} cat toots!")
            println("here are the first 3:")
            cats.take(3).forEach { status ->
                println(status)
            }
            println()
        }

        // Automatically stop after 10 seconds
        withTimeout(10_000L) {
            client.streaming.getPublicStream().collect { event ->
                if (event is UpdateEvent) {
                    println("new toot from ${event.payload.account.displayName}!")
                }
            }
        }
    }.join()
}
