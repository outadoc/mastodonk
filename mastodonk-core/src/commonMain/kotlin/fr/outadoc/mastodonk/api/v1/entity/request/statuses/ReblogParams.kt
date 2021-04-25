package fr.outadoc.mastodonk.api.v1.entity.request.statuses

import fr.outadoc.mastodonk.api.v1.entity.Visibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReblogParams(

    @SerialName("visibility")
    val visibility: Visibility? = null
)
