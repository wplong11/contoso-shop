package com.contoso.inventory

data class FeedDto<T>(
    val items: List<T>,
    val continuationToken: String?,
)
