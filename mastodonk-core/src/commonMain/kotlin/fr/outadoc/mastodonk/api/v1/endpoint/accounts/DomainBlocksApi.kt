package fr.outadoc.mastodonk.api.v1.endpoint.accounts

public interface DomainBlocksApi {

    public suspend fun getDomainBlocks(maxId: String?, limit: Int?, sinceId: String?): List<String>

    public suspend fun blockDomain(domain: String)

    public suspend fun unblockDomain(domain: String)
}