package com.example.retrofitapp.services

import com.example.retrofitapp.models.ToDo
import retrofit2.Call
import retrofit2.http.GET

interface TodoService {
    @GET("todos")
    fun getTodosFromRemote(): Call<List<ToDo>>
}