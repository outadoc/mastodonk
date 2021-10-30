package fr.outadoc.mastodonk.sample

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadParams
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo
import fr.outadoc.mastodonk.api.entity.streaming.DeleteEvent
import fr.outadoc.mastodonk.api.entity.streaming.UpdateEvent
import fr.outadoc.mastodonk.auth.AuthToken
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import fr.outadoc.mastodonk.client.MastodonClient
import fr.outadoc.mastodonk.paging.api.endpoint.search.searchHashtagsSource
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
        println("paging search for accounts with 'cats'")

        client.search.searchHashtagsSource(q = "cats").let { source ->
            val page = source.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 30,
                    placeholdersEnabled = false
                )
            ) as PagingSource.LoadResult.Page

            page.data.forEach { tag -> println(tag.name) }

            var nextKey: OffsetPageInfo? = page.nextKey
            var i = 1

            while (nextKey != null) {
                println("---- page $i")
                val p = source.load(
                    LoadParams.Append(
                        key = nextKey,
                        loadSize = 10,
                        placeholdersEnabled = false
                    )
                ) as PagingSource.LoadResult.Page

                p.data.forEach { tag -> println(tag.name) }

                nextKey = p.nextKey
                i++
            }
        }

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

private fun Account.toShortString() = "Account(id=$accountId,username=$acct)"
