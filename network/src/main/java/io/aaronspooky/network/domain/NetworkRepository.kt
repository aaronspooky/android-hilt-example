package io.aaronspooky.network.domain

interface NetworkRepository {

    /** */
    suspend fun fetchPosts(): String
}