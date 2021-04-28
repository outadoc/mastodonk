# Module mastodonk-core

This module contains the core functionality of `mastodonk`.

## About pagination

Paginated API calls support multiple pagination methods.

Quoting from the Mastodon changelog,

> The new pagination param `min_id` is the symmetrical opposite of `max_id`, i.e. it can be used for stepwise pagination from older to newer statuses.
>
> The difference to `since_id` is that `since_id` will always return the latest statuses, just merely cut off by the provided ID.

e.g., considering the latest status ids:

> 1, 2, 3 … 98, 99, 100

Then these queries will result in:

| `min_id` | `since_id` | `max_id` | `limit` | result              |
|----------|------------|----------|---------|---------------------|
| 1        |            |          | 5       | 2, 3, 4, 5, 6       |
|          | 1          |          | 5       | 96, 97, 98, 99, 100 |
|          | 97         |          |         | 98, 99, 100         |
|          | 50         | 54       |         | 51, 52, 53          |

# Package fr.outadoc.mastodonk.api.endpoint.accounts

Endpoints concerning user account management.

# Package fr.outadoc.mastodonk.api.endpoint.admin

Endpoints to perform moderation actions.

# Package fr.outadoc.mastodonk.api.endpoint.announcements

Endpoints to manage admin announcements.

# Package fr.outadoc.mastodonk.api.endpoint.apps

Endpoints concerning client application management.

# Package fr.outadoc.mastodonk.api.endpoint.instance

Endpoints to discover information about Mastodon instances.

# Package fr.outadoc.mastodonk.api.endpoint.notifications

Endpoints to receive activity notifications concerning an account.

# Package fr.outadoc.mastodonk.api.endpoint.proofs

Endpoints concerning identity providers.

# Package fr.outadoc.mastodonk.api.endpoint.search

Endpoints to search for content in accounts, statuses and hashtags.

# Package fr.outadoc.mastodonk.api.endpoint.statuses

Endpoints to publish, interact, and view information about statuses.

# Package fr.outadoc.mastodonk.api.endpoint.timelines

Endpoints to read and view timelines of statuses.

# Package fr.outadoc.mastodonk.api.entity

Objects returned by the Mastodon API.

# Package fr.outadoc.mastodonk.auth

Classes related to API authentication.

# Package fr.outadoc.mastodonk.client

Mastodon client, used to configure and access Mastodon APIs.
