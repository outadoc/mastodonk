package fr.outadoc.mastodonk.paging.api.endpoint.accounts

import fr.outadoc.mastodonk.api.endpoint.accounts.FavouritesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.PagingSource
import fr.outadoc.mastodonk.paging.pagingSource

public actual fun FavouritesApi.getFavouritesSource(): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getFavourites(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
