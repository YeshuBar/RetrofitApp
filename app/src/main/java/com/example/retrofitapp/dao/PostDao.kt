package com.example.retrofitapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitapp.models.Post
@Dao
interface PostDao {

    @Query("SELECT * FROM posts")
    suspend fun getPostsFromDB(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)
}
