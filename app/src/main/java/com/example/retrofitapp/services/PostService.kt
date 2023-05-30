package com.example.retrofitapp.services

import com.example.retrofitapp.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun getPostsFromRemote(): Call<List<Post>>
}