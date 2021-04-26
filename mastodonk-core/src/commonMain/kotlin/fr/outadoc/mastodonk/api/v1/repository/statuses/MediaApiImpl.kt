package fr.outadoc.mastodonk.api.v1.repository.statuses

import fr.outadoc.mastodonk.api.v1.endpoint.statuses.MediaApi
import fr.outadoc.mastodonk.api.v1.entity.Attachment
import fr.outadoc.mastodonk.api.v1.entity.request.File
import fr.outadoc.mastodonk.api.v1.entity.request.toFormPart
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class MediaApiImpl(private val client: MastodonHttpClient) : MediaApi {

    override suspend fun getMediaAttachment(id: String) {
        return client.request("/api/v1/media/${id.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun uploadMediaAttachment(
        file: File,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment {
        val filePart = file.toFormPart("file")
        val thumbnailPart = thumbnail?.toFormPart("thumbnail")
        return client.request("/api/v2/media") {
            method = HttpMethod.Post
            formData {
                append(filePart)
                thumbnailPart?.let { append(it) }
            }
        }
    }

    override suspend fun updateMediaAttachment(
        id: String,
        file: File?,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment {
        val filePart = file?.toFormPart("file")
        val thumbnailPart = thumbnail?.toFormPart("thumbnail")
        return client.request("/api/v1/media/${id.trim()}") {
            method = HttpMethod.Post
            formData {
                filePart?.let { append(it) }
                thumbnailPart?.let { append(it) }
            }
        }
    }
}
