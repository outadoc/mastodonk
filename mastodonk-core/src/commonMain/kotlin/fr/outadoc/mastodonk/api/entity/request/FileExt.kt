package fr.outadoc.mastodonk.api.entity.request

import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.utils.io.*

internal suspend fun File.toFormPart(name: String): FormPart<ByteArray> {
    return FormPart(name, contents.readAvailable(), Headers.build {
        append(HttpHeaders.ContentType, contentType)
        append(HttpHeaders.ContentDisposition, "filename=${filename.encodeURLPath()}")
    })
}

internal suspend fun ByteReadChannel.readAvailable(): ByteArray {
    return ByteArray(availableForRead).apply {
        readAvailable(this, 0, size)
    }
}
