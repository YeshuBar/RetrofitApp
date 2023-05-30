package com.example.retrofitapp.models

import com.google.gson.annotations.SerializedName

data class ToDo(
    val userId: Int,
    val id: Int,
    val text: String,
    val completed: Boolean
)

