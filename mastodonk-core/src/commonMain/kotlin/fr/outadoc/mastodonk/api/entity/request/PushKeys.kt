package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Push keys used for notifications.
 */
@Serializable
public data class PushKeys(

    /**
     * User agent public key.
     *
     * Base64 encoded string of public key of ECDH key using prime256v1 curve.
     */
    @SerialName("p256dh")
    val p256dhBase64: String,

    /**
     * Auth secret.
     *
     * Base64 encoded string of 16 bytes of random data.
     */
    @SerialName("auth")
    val authBase64: String
)
