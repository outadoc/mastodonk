package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.v1.entity.Error

public class MastodonApiException(
    public val errorCode: Int,
    public val apiError: Error
) : Exception(apiError.error)