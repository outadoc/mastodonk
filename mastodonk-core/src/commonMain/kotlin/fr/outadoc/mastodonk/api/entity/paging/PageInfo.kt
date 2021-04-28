package fr.outadoc.mastodonk.api.entity.paging

public data class PageInfo(
    val minId: String? = null,
    val sinceId: String? = null,
    val maxId: String? = null,
    val limit: Int? = null
)
