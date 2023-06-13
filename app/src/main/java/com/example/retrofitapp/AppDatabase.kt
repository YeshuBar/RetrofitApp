package com.example.retrofitapp

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitapp.dao.PostDao
import com.example.retrofitapp.dao.CommentDao
import com.example.retrofitapp.models.Comment
import com.example.retrofitapp.models.Post
import com.example.retrofitapp.repositories.RepoFactory


@Database(entities = [Comment::class, Post::class], version = 1)
internal abstract  class AppDatabase : RoomDatabase() {

    abstract fun  commentDao() : CommentDao
    abstract fun  postDao() : PostDao

    companion object {

        private var INSTANCE : AppDatabase? = null

        fun getDataBase(): AppDatabase{
            if (INSTANCE != null){
                return INSTANCE!!
            }

            INSTANCE = Room.databaseBuilder(
                RepoFactory.context,
                AppDatabase::class.java,"app_database").build()

            return INSTANCE!!
        }
    }
}