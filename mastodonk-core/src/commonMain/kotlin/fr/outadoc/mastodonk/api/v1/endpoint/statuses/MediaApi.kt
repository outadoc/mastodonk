package fr.outadoc.mastodonk.api.v1.endpoint.statuses

import fr.outadoc.mastodonk.api.v1.entity.Attachment
import fr.outadoc.mastodonk.api.v1.entity.request.File

public interface MediaApi {

    public suspend fun getMediaAttachment(id: String)

    public suspend fun uploadMediaAttachment(
        file: File,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment

    public suspend fun updateMediaAttachment(
        id: String,
        file: File?,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment
}
