package com.example.retrofitapp.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.ToDoRepoFactory
import com.example.retrofitapp.models.ToDo
import com.example.retrofitapp.repositories.TodoRepo
import com.example.retrofitapp.repositories.TodoRepoImpl
import com.example.retrofitapp.utilities.RetrofitSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class State {
    Idle
}



class TodoViewmodel() : ViewModel() {

    val state = MutableLiveData<State>().apply {
        postValue(State.Idle)
    }
    val toDoLiveData = MutableLiveData<List<ToDo>>()

    fun getToDos() {
        viewModelScope.launch {
            val todoRepo: TodoRepo = TodoRepoImpl
            //RetrofitSingleton.todoService.getTodosFromRemote()
            todoRepo.getTodosFromRemote().enqueue(object : Callback<List<ToDo>> {
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
//    fun getToDosFromDataBase() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val listOfToDos = ToDoRepoFactory.repository.getTodosFromRemote()
//            toDoLiveData.postValue(listOfToDos)
//        }
//    }
}
