package fr.outadoc.mastodonk.api.entity.paging

public data class Page<T>(
    public val contents: T,
    public val next: PageInfo?,
    public val prev: PageInfo?
)
