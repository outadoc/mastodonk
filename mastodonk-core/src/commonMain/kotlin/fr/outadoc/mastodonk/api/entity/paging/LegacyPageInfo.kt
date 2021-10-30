package fr.outadoc.mastodonk.api.entity.paging

/**
 * Represents a pagination state, to get a specific page of results from an API.
 */
public data class LegacyPageInfo(

    /**
     * The number of items to skip at the start of the queried list.
     */
    val offset: Int? = null
)
