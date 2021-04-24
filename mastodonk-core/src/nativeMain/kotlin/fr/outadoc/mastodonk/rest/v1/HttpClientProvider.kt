package fr.outadoc.mastodonk.rest.v1

import fr.outadoc.mastodonk.rest.installMastodonResponseValidator
import fr.outadoc.mastodonk.rest.installMastodonSerializer
import io.ktor.client.*
import io.ktor.client.engine.curl.*

internal actual class HttpClientProvider {

    actual val httpClient: HttpClient
        get() = HttpClient(Curl) {
            installMastodonSerializer()
            installMastodonResponseValidator()
        }
}