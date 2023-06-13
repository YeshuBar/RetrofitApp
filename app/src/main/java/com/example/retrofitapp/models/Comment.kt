package com.example.retrofitapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( "comments")
data class Comment(
   @PrimaryKey val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

