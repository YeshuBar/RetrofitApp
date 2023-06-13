package com.example.retrofitapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.repositories.RepoFactory
import com.example.retrofitapp.models.Post
import com.example.retrofitapp.enums.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel() : ViewModel() {

    val postLiveData = MutableLiveData<List<Post>>()
    val state = MutableLiveData<State>().apply {
        postValue(State.IDLE)
    }

    fun getPosts() {
        viewModelScope.launch {
            RepoFactory.repository.getPostsFromRemote().enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    val posts = response.body()
                    viewModelScope.launch {
                        if (posts != null) {
                            for (post in posts) {
                                RepoFactory.repository.addPostsToDB(post)
                            }
                        }
                    }
                    postLiveData.postValue(posts)
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    print("blu")
                }
            })
        }
    }

    fun getPostsFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            val listOfPosts = RepoFactory.repository.getPostsFromDB()
            postLiveData.postValue(listOfPosts)
        }
    }
}