package fr.outadoc.mastodonk.api.endpoint.statuses

import fr.outadoc.mastodonk.api.entity.Attachment
import fr.outadoc.mastodonk.api.entity.request.File

/**
 * Attach media to authored statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/)
 */
public interface MediaApi {

    /**
     * Gets a single attachment by its id.
     */
    public suspend fun getMediaAttachment(attachmentId: String): Attachment

    /**
     * Creates an attachment to be used with a new status.
     *
     * @param file The file to be attached.
     * @param thumbnail The custom thumbnail of the media to be attached.
     * @param description A plain-text description of the media, for accessibility purposes.
     * @param focus Two floating points (x,y), comma-delimited, ranging from -1.0 to 1.0
     */
    public suspend fun uploadMediaAttachment(
        file: File,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment

    /**
     * Get an attachment, before it is attached to a status and posted,
     * but after it is accepted for processing.
     *
     * @param file The file to be attached.
     * @param thumbnail The custom thumbnail of the media to be attached.
     * @param description A plain-text description of the media, for accessibility purposes.
     * @param focus Two floating points (x,y), comma-delimited, ranging from -1.0 to 1.0
     */
    public suspend fun updateMediaAttachment(
        attachmentId: String,
        file: File?,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): Attachment
}
