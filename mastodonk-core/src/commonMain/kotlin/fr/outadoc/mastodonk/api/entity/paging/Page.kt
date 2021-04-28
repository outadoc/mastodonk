package fr.outadoc.mastodonk.api.entity.paging

public data class Page<T>(
    public val contents: T,
    public val next: PaginationState?,
    public val prev: PaginationState?
)
