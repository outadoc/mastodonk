package fr.outadoc.mastodonk.api.v1.entity.request

import io.ktor.utils.io.*

public data class File(
    val contents: ByteReadChannel,
    val filename: String,
    val contentType: String
)
