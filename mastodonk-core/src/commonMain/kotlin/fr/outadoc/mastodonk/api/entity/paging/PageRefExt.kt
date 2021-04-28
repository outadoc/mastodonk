package fr.outadoc.mastodonk.api.entity.paging

import io.ktor.http.*
import io.ktor.util.*

private val linkRegexCache = Regex("<(.+)>; rel=\"(.*)\"")

/**
 * Parses a Link header, used by Mastodon for pagination, into a list of
 * parameters required to fetch the next and previous pages.
 *
 * @receiver The value of a Link header formatted like:
 * <https://mastodon.social/api/v1/accounts/14715/followers?limit=2&max_id=7486869>; rel="next", <https://mastodon.social/api/v1/accounts/14715/followers?limit=2&since_id=7489740>; rel="prev"
 *
 * @return A list of the parameters required to fetch the next and previous page,
 * mapped with `rel` as the key.
 */
internal fun String.parseLinkHeaderToPageRefs(): Map<String, PageRef> {
    val parts = split(',').map(String::trim)
    return parts.mapNotNull { part ->
        linkRegexCache.find(part)
    }.associate { res ->
        val rel = res.groupValues[2]
        val params = Url(res.groupValues[1])
            .parameters
            .flattenEntries()

        rel to PageRef(params)
    }
}