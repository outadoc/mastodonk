package fr.outadoc.mastodonk.api.entity.paging

/**
 * A page of results from the API.
 *
 * To get the next or previous page, see [nextPage] and [previousPage].
 */
public data class Page<T>(

    /**
     * The page contents.
     */
    public val contents: T,

    /**
     * An object that can be passed to the calling API
     * to get the next page of contents.
     */
    public val nextPage: PageInfo?,

    /**
     * An object that can be passed to the calling API
     * to get the previous page of contents.
     */
    public val previousPage: PageInfo?
)
