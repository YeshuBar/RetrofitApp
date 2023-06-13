package com.example.retrofitapp.repositories

import android.app.Application
import com.example.retrofitapp.repositories.Repo
import com.example.retrofitapp.repositories.RepoImpl


object RepoFactory {
        lateinit var context: Application

        val repository: Repo = RepoImpl
    }