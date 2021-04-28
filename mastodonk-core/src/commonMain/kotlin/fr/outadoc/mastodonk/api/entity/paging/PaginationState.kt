package fr.outadoc.mastodonk.api.entity.paging

public data class PaginationState(
    val minId: String?,
    val sinceId: String?,
    val maxId: String?,
    val limit: Int?
)
