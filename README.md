# mastodonk — A Kotlin/Multiplatform Mastodon API client
[![JVM Build](https://github.com/outadoc/mastodonk/actions/workflows/jvm-build.yml/badge.svg)](https://github.com/outadoc/mastodonk/actions/workflows/jvm-build.yml)
[![JS Build](https://github.com/outadoc/mastodonk/actions/workflows/js-build.yml/badge.svg)](https://github.com/outadoc/mastodonk/actions/workflows/js-build.yml)
[![Native Build](https://github.com/outadoc/mastodonk/actions/workflows/native-build.yml/badge.svg)](https://github.com/outadoc/mastodonk/actions/workflows/native-build.yml)

## Description
> ⚠ This library and its documentation are a work in progress!

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
        val instance = client.instance.getInstance()
        println("connected to instance ${instance.title} at ${instance.uri}!")

        // Get a list of public toots
        val toots = client.timelines.getPublicTimeline()

        // Get some #cats in your life
        val catToots = client.timelines.getHashtagTimeline("cats")

        // Subscribe to streaming APIs and get a Flow
        client.streaming.getPublicStream().collect { toot ->
            println(toot)
        }

    }.join()
}
```
