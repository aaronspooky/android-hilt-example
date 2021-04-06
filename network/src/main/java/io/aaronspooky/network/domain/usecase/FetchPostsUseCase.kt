package io.aaronspooky.network.domain.usecase

import io.aaronspooky.network.domain.NetworkRepository

class FetchPostsUseCase(
    private val repository: NetworkRepository
) {
    /** */
    suspend operator fun invoke(): String = repository.fetchPosts()
}