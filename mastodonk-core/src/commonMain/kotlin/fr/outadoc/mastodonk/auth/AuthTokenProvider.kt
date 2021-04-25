package fr.outadoc.mastodonk.auth

public fun interface AuthTokenProvider {
    public fun provideAuthToken(): AuthToken?
}
