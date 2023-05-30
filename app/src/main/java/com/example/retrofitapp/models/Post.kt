package com.example.retrofitapp.models

import com.google.gson.annotations.SerializedName

data class Post(
    val userId: Int,
    val id: Int,
    @SerializedName("title") val text: String,
    val body: String
    )
