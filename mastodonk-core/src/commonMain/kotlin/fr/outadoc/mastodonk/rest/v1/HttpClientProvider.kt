package fr.outadoc.mastodonk.rest.v1

import io.ktor.client.*

public expect class HttpClientProvider() {
    public val httpClient: HttpClient
}