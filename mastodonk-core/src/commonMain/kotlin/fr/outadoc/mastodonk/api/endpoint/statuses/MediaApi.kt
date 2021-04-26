package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.Attachment
import fr.outadoc.mastodonk.api.entity.request.File

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
