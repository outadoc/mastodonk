package fr.outadoc.mastodonk.api.entity.paging

public data class Page<T>(
    public val contents: List<T>,
    public val next: PageRef?,
    public val prev: PageRef?
)
