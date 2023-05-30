package com.example.retrofitapp.repositories

import com.example.retrofitapp.models.ToDo
import com.example.retrofitapp.utilities.RetrofitSingleton
import retrofit2.Call

interface TodoRepo {
    suspend fun getTodosFromRemote() : Call<List<ToDo>>
}
object TodoRepoImpl : TodoRepo {
    override suspend fun getTodosFromRemote(): Call<List<ToDo>> {
        return RetrofitSingleton.todoService.getTodosFromRemote()
    }
}