package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.api.entity.streaming.DeleteEvent
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
        client.instance.getInstanceInfo().let { instance ->
            println("connected to instance ${instance.title} at ${instance.uri}!")
            println(instance)
            println()
        }

        client.timelines.getPublicTimeline().let { timeline ->
            println(timeline)
            println()
        }

        client.timelines.getHashtagTimeline("cats").let { cats ->
            println("got ${cats.size} cat statuses!")
            println("here are the first 3:")
            cats.take(3).forEach { status ->
                println(status)
            }
            println()
        }

        // Automatically stop after 10 seconds
        withTimeout(10_000L) {
            client.streaming.getPublicStream().collect { event ->
                when (event) {
                    is UpdateEvent -> println("new status from ${event.payload.account.displayName}!")
                    is DeleteEvent -> println("status ${event.statusId} was deleted")
                    else -> Unit
                }
            }
        }
    }.join()
}
