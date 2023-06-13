package com.example.retrofitapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.repositories.RepoFactory
import com.example.retrofitapp.enums.State
import com.example.retrofitapp.models.Comment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentViewModel() : ViewModel() {

    val commentLiveData = MutableLiveData<List<Comment>>()
    val state = MutableLiveData<State>().apply {
        postValue(State.IDLE)
    }

    fun getComments() {
        viewModelScope.launch {
            RepoFactory.repository.getCommentsFromRemote().enqueue(object : Callback<List<Comment>> {
                override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                    val comments = response.body()
                    viewModelScope.launch {
                        if (comments != null) {
                            for (comment in comments) {
                                RepoFactory.repository.addCommentsToDB(comment)
                            }
                        }
                    }
                    commentLiveData.postValue(comments)
                }

                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                    print("bla")
                }
            })
        }
    }

    fun getCommentsFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            val listOfComments = RepoFactory.repository.getCommentsFromDB()
            commentLiveData.postValue(listOfComments)
        }
    }
}
