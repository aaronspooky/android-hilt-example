package io.aaronspooky.network.data

interface NetworkRemoteDataSource {

    /** */
    suspend fun fetchPosts(): String
}