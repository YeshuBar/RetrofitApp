package com.example.retrofitapp.repositories

import com.example.retrofitapp.models.Post
import com.example.retrofitapp.models.ToDo
import com.example.retrofitapp.utilities.RetrofitSingleton
import retrofit2.Call

interface Repo {
    suspend fun getTodosFromRemote() : Call<List<ToDo>>
    suspend fun getPostsFromRemote() : Call<List<Post>>
}
object RepoImpl : Repo {
    override suspend fun getTodosFromRemote(): Call<List<ToDo>> {
        return RetrofitSingleton.todoService.getTodosFromRemote()
    }

    override suspend fun getPostsFromRemote(): Call<List<Post>> {
        return RetrofitSingleton.postService.getPostsFromRemote()
    }
}