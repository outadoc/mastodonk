package fr.outadoc.mastodonk.sample

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadParams
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.streaming.DeleteEvent
import fr.outadoc.mastodonk.api.entity.streaming.UpdateEvent
import fr.outadoc.mastodonk.auth.AuthToken
import fr.outadoc.mastodonk.auth.AuthTokenProvider
import fr.outadoc.mastodonk.client.MastodonClient
import fr.outadoc.mastodonk.paging.api.endpoint.search.searchAccountsSource
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

        client.search.searchAccountsSource(q = "cats").let { source ->
            val loadSize = 10

            println("---- page 1")
            val page1 = source.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = loadSize,
                    placeholdersEnabled = false
                )
            ) as PagingSource.LoadResult.Page

            page1.data.forEach { account -> println(account.toShortString()) }

            println("---- page 2")
            val page2 = source.load(
                LoadParams.Append(
                    key = page1.nextKey!!,
                    loadSize = loadSize,
                    placeholdersEnabled = false
                )
            ) as PagingSource.LoadResult.Page

            page2.data.forEach { account -> println(account.toShortString()) }
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
