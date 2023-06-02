package com.example.retrofitapp.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.retrofitapp.ToDoAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.models.ToDo
import com.example.retrofitapp.viewmodels.TodoViewmodel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toDoViewModel: TodoViewmodel by viewModels()

        toDoViewModel.toDoLiveData.observe(this, {
            print("bla")
        })

        toDoViewModel.getToDos()

//        val toDoViewModel2 = ViewModelProvider(this).get(TodoViewmodel::class.java)

        toDoViewModel.toDoLiveData.observe(this)
        {
            binding.todoRv.addItemDecoration(
                DividerItemDecoration(
                    binding.todoRv.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            val toDoAdapter =
                ToDoAdapter(it, this@MainActivity)
            binding.todoRv.adapter = toDoAdapter
        }
    }
}

