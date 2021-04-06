package io.aaronspooky.network.data

import io.aaronspooky.network.domain.NetworkRepository

class NetworkRepositoryImpl(
    private val remoteDataSource: NetworkRemoteDataSource
): NetworkRepository {

    /** */
    override suspend fun fetchPosts(): String =
        remoteDataSource.fetchPosts()
}