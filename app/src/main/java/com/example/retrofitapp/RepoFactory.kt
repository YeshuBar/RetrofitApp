package com.example.retrofitapp

import com.example.retrofitapp.repositories.Repo
import com.example.retrofitapp.repositories.RepoImpl


object RepoFactory {
//        lateinit var context: Application

        val repository: Repo = RepoImpl
    }