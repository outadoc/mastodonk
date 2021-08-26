package fr.outadoc.mastodonk.sample

import fr.outadoc.mastodonk.api.entity.streaming.DeleteEvent
import fr.outadoc.mastodonk.api.entity.streaming.UpdateEvent
import fr.outadoc.mastodonk.auth.AuthToken
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import fr.outadoc.mastodonk.client.MastodonClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    val client = MastodonClient {
        domain = "mastodon.social"
        enableLogging = true
        authTokenProvider = AuthTokenProvider {
            AuthToken(accessToken = "esFZExSoQHlhjxMYZmxQIEIlthWWkwo2gtNrnux4Jow")
        }
    }

    GlobalScope.launch {
        client.instance.getInstanceInfo().let { instance ->
            println("connected to instance ${instance.title} at ${instance.uri}!")
            println(instance)
            println()
        }

        client.timelines.getPublicTimeline().let { timeline ->
            println(timeline.contents)
            println(timeline.nextPage)
            println()
        }

        client.timelines.getHashtagTimeline(
            "cats",
            limit = 3
        ).let { cats ->
            println("three cat statuses:")
            cats.contents.forEach { status -> println(status) }

            val nextCats = client.timelines.getHashtagTimeline(
                "cats",
                pageInfo = cats.nextPage
            )

            println("next three cat statuses:")
            nextCats.contents.forEach { status -> println(status) }
        }

        println()
        println("start streaming statuses from the public stream")

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
