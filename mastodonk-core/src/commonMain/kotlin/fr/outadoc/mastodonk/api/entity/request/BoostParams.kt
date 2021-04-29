package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.StatusVisibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BoostParams(

    @SerialName("visibility")
    val visibility: StatusVisibility? = null
)
