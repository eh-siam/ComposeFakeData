package com.example.composefakedata.network

import com.example.composefakedata.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts() : List<Post>
}