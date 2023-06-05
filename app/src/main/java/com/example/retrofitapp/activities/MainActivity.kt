package com.example.retrofitapp.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.retrofitapp.adapter.PostAdapter
import com.example.retrofitapp.adapter.ToDoAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.viewmodels.PostViewmodel
import com.example.retrofitapp.viewmodels.TodoViewmodel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toDoViewModel: TodoViewmodel by viewModels()

//        val toDoViewModel2 = ViewModelProvider(this).get(TodoViewmodel::class.java)
        toDoViewModel.toDoLiveData.observe(this) {
            binding.todoRv.addItemDecoration(
                DividerItemDecoration(
                    binding.todoRv.context,
                    DividerItemDecoration.VERTICAL
                )
            )

            val toDoAdapter = ToDoAdapter(it)
            binding.todoRv.adapter = toDoAdapter
        }

        toDoViewModel.getToDos()

        val postViewmodel: PostViewmodel by viewModels()

        postViewmodel.postLiveData.observe(this) {
            binding.postRv.addItemDecoration(
                DividerItemDecoration(
                    binding.postRv.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            val postAdapter =
                PostAdapter(it)
            binding.postRv.adapter = postAdapter
        }

        postViewmodel.getPosts()

    }
}

