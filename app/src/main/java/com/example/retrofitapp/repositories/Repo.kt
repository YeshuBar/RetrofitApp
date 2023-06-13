package com.example.retrofitapp.repositories

import com.example.retrofitapp.AppDatabase
import com.example.retrofitapp.models.Post
import com.example.retrofitapp.models.Comment
import com.example.retrofitapp.utilities.RetrofitSingleton
import retrofit2.Call

interface Repo {
     fun getCommentsFromRemote() : Call<List<Comment>>
    suspend fun getPostsFromRemote() : Call<List<Post>>

    suspend fun addCommentsToDB(comments: Comment)
    suspend fun addPostsToDB(post: Post)

    suspend fun getCommentsFromDB(): List<Comment>
    suspend fun getPostsFromDB(): List<Post>
}
internal object RepoImpl : Repo {

    override  fun getCommentsFromRemote(): Call<List<Comment>> {
        return RetrofitSingleton.commentService.getCommentsFromRemote()
    }

    override suspend fun getPostsFromRemote(): Call<List<Post>> {
        return RetrofitSingleton.postService.getPostsFromRemote()
    }

    override suspend fun addCommentsToDB(comments: Comment) {
        AppDatabase.getDataBase().commentDao().insert(comments)
    }

    override suspend fun addPostsToDB(post: Post) {
        AppDatabase.getDataBase().postDao().insert(post)
    }

    override suspend fun getCommentsFromDB(): List<Comment> {
        return AppDatabase.getDataBase().commentDao().getCommentsFromDB()
    }

    override suspend fun getPostsFromDB(): List<Post> {
        return AppDatabase.getDataBase().postDao().getPostsFromDB()
    }
}