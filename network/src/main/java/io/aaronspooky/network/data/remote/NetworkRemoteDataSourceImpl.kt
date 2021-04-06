package io.aaronspooky.network.data.remote

import io.aaronspooky.network.data.NetworkRemoteDataSource

class NetworkRemoteDataSourceImpl(
    private val apiSource: ApiSource
): NetworkRemoteDataSource {

    /** */
    override suspend fun fetchPosts(): String = try {
        val response = apiSource.fetchPostsRequest()
        if (response.isSuccessful) {
            response.body().toString()
        } else {
            response.errorBody().toString()
        }
    } catch (e: Exception) {
        e.message ?: e.javaClass.toString()
    }
}