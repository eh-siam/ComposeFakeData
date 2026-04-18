package com.example.composefakedata.network

import retrofit2.Retrofit

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiService::class.java)
    }
}