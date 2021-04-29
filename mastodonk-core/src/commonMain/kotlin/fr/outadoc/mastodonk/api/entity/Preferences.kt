package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Preferences(

    /**
     * Default visibility for new posts.
     *
     * Equivalent to [Source.defaultPrivacy].
     */
    @SerialName("posting:default:visibility")
    val defaultVisibility: StatusVisibility,

    /**
     * Default sensitivity flag for new posts.
     */
    @SerialName("posting:default:sensitive")
    val defaultSensitivity: Boolean,

    /**
     * Default language for new posts.
     *
     * ISO 639-1 language two-letter code.
     */
    @SerialName("posting:default:language")
    val defaultLanguage: String,

    /**
     * Whether media attachments should be automatically displayed or blurred/hidden.
     */
    @SerialName("reading:expand:media")
    val defaultMediaVisibility: MediaVisibility,

    /**
     * Whether statuses behind a content warning should be expanded by default.
     */
    @SerialName("reading:expand:spoilers")
    val defaultExpandContentWarnings: Boolean
)
