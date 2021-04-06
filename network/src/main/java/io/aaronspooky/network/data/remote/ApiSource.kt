package io.aaronspooky.network.data.remote

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiSource {

    /** */
    @GET(URL.POSTS)
    suspend fun fetchPostsRequest(): Response<ResponseBody>

    /** */
    private object URL {
        const val POSTS = "/posts"
    }
}