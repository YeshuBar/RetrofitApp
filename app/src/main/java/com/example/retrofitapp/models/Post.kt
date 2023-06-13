package com.example.retrofitapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("posts")
data class Post(
    @PrimaryKey val userId: Int,
    val id: Int,
    @SerializedName("title") val text: String,
    val body: String
    )
