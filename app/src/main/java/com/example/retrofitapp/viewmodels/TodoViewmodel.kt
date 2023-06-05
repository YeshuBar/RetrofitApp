package com.example.retrofitapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.RepoFactory
import com.example.retrofitapp.models.State
import com.example.retrofitapp.models.ToDo
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoViewmodel() : ViewModel() {

    val state = MutableLiveData<State>().apply {
        postValue(State.Idle)
    }
    val toDoLiveData = MutableLiveData<List<ToDo>>()

    fun getToDos() {
        viewModelScope.launch {
            //RetrofitSingleton.todoService.getTodosFromRemote()
            RepoFactory.repository.getTodosFromRemote().enqueue(object : Callback<List<ToDo>> {
                override fun onResponse(call: Call<List<ToDo>>, response: Response<List<ToDo>>) {
                    val todos = response.body()
                    toDoLiveData.postValue(todos)
                }

                override fun onFailure(call: Call<List<ToDo>>, t: Throwable) {
                    print("bla")
                }
            })
        }
    }
}

