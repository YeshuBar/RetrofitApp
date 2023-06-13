package com.example.retrofitapp.services

import com.example.retrofitapp.models.Comment
import retrofit2.Call
import retrofit2.http.GET

interface CommentService {
    @GET("comments")
    fun getCommentsFromRemote(): Call<List<Comment>>

}