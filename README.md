# mastodonk — A Kotlin/Multiplatform Mastodon API client

[![JVM Build](https://github.com/outadoc/mastodonk/actions/workflows/jvm-build.yml/badge.svg)](https://github.com/outadoc/mastodonk/actions/workflows/jvm-build.yml)
[![JS Build](https://github.com/outadoc/mastodonk/actions/workflows/js-build.yml/badge.svg)](https://github.com/outadoc/mastodonk/actions/workflows/js-build.yml)
[![Native Build](https://github.com/outadoc/mastodonk/actions/workflows/native-build.yml/badge.svg)](https://github.com/outadoc/mastodonk/actions/workflows/native-build.yml)

## Documentation

[API Reference](https://outadoc.github.io/mastodonk/)

## Usage

Mastodonk provides a Kotlin-first API based on coroutines and Flows.

```kt
fun main() = runBlocking {

    val client = MastodonClient {
        baseUrl = "https://mastodon.social"
        authTokenProvider = AuthTokenProvider {
            // Provide an authentication token
            AuthToken(accessToken = "your-access-token-here")
        }
    }

    GlobalScope.launch {

        // Get some information about the configured instance
        val instance = client.instance.getInstanceInfo()
        println("connected to instance ${instance.title} at ${instance.uri}!")

        // Get a list of public toots
        val toots = client.timelines.getPublicTimeline()

        // Get some #cats in your life
        val catToots = client.timelines.getHashtagTimeline("cats")

        // Easy pagination
        val moreCatToots = client.timelines.getHashtagTimeline(
            "cats",
            pageInfo = catToots.nextPage
        )

        // Subscribe to streaming APIs and get a Flow
        client.streaming.getPublicStream().collect { event ->
            when (event) {
                is UpdateEvent -> println("new status from ${event.payload.account.displayName}!")
                else -> Unit
            }
        }

    }.join()
}
```
