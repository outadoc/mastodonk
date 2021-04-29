package fr.outadoc.mastodonk.api.entity.request

import io.ktor.utils.io.*

/**
 * A file to be uploaded to a Mastodon API.
 */
public data class File(

    /**
     * Raw file contents.
     */
    val contents: ByteReadChannel,

    /**
     * Name of the file.
     */
    val filename: String,

    /**
     * MIME content type of the file.
     */
    val contentType: String
)
