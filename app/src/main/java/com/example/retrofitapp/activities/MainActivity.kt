package com.example.retrofitapp.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapp.R
import com.example.retrofitapp.viewmodels.TodoViewmodel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toDoViewModel: TodoViewmodel by viewModels()

        toDoViewModel.toDoLiveData.observe(this, {
            print("bla")
        })

        toDoViewModel.getToDos()
    }
}