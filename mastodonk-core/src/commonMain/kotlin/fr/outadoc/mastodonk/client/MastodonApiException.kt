package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.entity.Error

public class MastodonApiException(

    /**
     * HTTP status code returned by the API.
     */
    public val errorCode: Int,

    /**
     * Error details optionally returned by the API.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    public val apiError: Error?

) : Exception(apiError?.error)
