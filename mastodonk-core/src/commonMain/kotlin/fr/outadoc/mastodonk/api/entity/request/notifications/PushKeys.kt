package fr.outadoc.mastodonk.api.entity.request.notifications

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PushKeys(

    @SerialName("p256dh")
    val p256dhBase64: String,

    @SerialName("auth")
    val authBase64: String
)
