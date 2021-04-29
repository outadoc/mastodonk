package fr.outadoc.mastodonk.api.repository.statuses

import fr.outadoc.mastodonk.api.endpoint.statuses.MediaApi
import fr.outadoc.mastodonk.api.entity.Attachment
import fr.outadoc.mastodonk.api.entity.request.File
import fr.outadoc.mastodonk.api.entity.request.toFormPart
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class MediaApiImpl(private val client: MastodonHttpClient) : MediaApi {

    override suspend fun getMediaAttachment(attachmentId: String): Attachment? {
        return client.requestOrNull("/api/v1/media/${attachmentId.trim()}") {
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
                description?.let { append("description", it) }
                focus?.let { append("focus", it) }
                append(filePart)
                thumbnailPart?.let { append(it) }
            }
        }
    }

    override suspend fun updateMediaAttachment(
        attachmentId: String,
        file: File?,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment {
        val filePart = file?.toFormPart("file")
        val thumbnailPart = thumbnail?.toFormPart("thumbnail")
        return client.request("/api/v1/media/${attachmentId.trim()}") {
            method = HttpMethod.Post
            formData {
                description?.let { append("description", it) }
                focus?.let { append("focus", it) }
                filePart?.let { append(it) }
                thumbnailPart?.let { append(it) }
            }
        }
    }
}
