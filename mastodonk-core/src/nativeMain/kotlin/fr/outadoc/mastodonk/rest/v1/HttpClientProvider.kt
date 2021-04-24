package fr.outadoc.mastodonk.rest.v1

import fr.outadoc.mastodonk.rest.installMastodonSerializer
import io.ktor.client.*
import io.ktor.client.engine.curl.*

public actual class HttpClientProvider {

    public actual val httpClient: HttpClient
        get() = HttpClient(Curl) {
            installMastodonSerializer()
        }
}