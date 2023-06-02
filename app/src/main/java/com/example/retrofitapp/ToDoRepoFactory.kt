package com.example.retrofitapp

import android.app.Application
import com.example.retrofitapp.repositories.TodoRepo
import com.example.retrofitapp.repositories.TodoRepoImpl

object ToDoRepoFactory {
        lateinit var context: Application

        val repository: TodoRepo = TodoRepoImpl
    }