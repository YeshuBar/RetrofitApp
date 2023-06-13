package com.example.retrofitapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitapp.models.Comment

@Dao
interface CommentDao {
    @Query("SELECT * FROM comments")
    suspend fun getCommentsFromDB(): List<Comment>

    //@Query("SELECT * FROM customer_table WHERE id LIKE :id LIMIT 1")
    // suspend fun findById (id: Int): Customer

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(comments: Comment)
}