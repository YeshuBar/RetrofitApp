package com.example.retrofitapp.utilities

import com.example.retrofitapp.services.PostService
import com.example.retrofitapp.services.CommentService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val commentService: CommentService = retrofit.create(CommentService::class.java)
    val postService: PostService = retrofit.create(PostService::class.java)
}