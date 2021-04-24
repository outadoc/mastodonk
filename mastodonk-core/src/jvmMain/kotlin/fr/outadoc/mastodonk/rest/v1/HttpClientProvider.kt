package fr.outadoc.mastodonk.rest.v1

import fr.outadoc.mastodonk.rest.installMastodonSerializer
import io.ktor.client.*
import io.ktor.client.engine.cio.*

public actual class HttpClientProvider {

    public actual val httpClient: HttpClient
        get() = HttpClient(CIO) {
            engine {
                endpoint {
                    keepAliveTime = 5_000
                    connectTimeout = 5_000
                    requestTimeout = 30_000
                    connectAttempts = 5
                }
            }

            installMastodonSerializer()
        }
}
