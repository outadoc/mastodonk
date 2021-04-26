package fr.outadoc.mastodonk.api.v1.repository.proofs

import fr.outadoc.mastodonk.api.v1.endpoint.proofs.ProofsApi
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class ProofsApiImpl(private val client: MastodonHttpClient) : ProofsApi {

    override suspend fun getProofs(provider: String?, username: String?): String {
        return client.request("/api/proofs") {
            method = HttpMethod.Get
            parameter("provider", provider)
            parameter("username", username)
        }
    }
}
