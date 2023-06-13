package com.example.retrofitapp.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.retrofitapp.R
import com.example.retrofitapp.adapter.PostAdapter
import com.example.retrofitapp.databinding.ActivityPostBinding
import com.example.retrofitapp.models.Post
import com.example.retrofitapp.viewmodels.PostViewModel

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val postViewModel: PostViewModel by viewModels()

        binding.fetchPostRemote.setOnClickListener {


            postViewModel.postLiveData.observe(this) {
                postAdapter(it)
            }

            postViewModel.getPosts()

        }
        binding.fetchPostLocal.setOnClickListener {

            postViewModel.postLiveData.observe(this) {
                if (it.isEmpty()) {
                    AlertDialog.Builder(this)
                        .setTitle(getString(R.string.please_fetch_first))
                        .setMessage(getString(R.string.please_fetch_first))
                        .setPositiveButton(android.R.string.ok) { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                } else {
                    postAdapter(it)


                }
            }
            postViewModel.getPostsFromDB()
        }
    }

    fun postAdapter(posts: List<Post>) {
        binding.postRv.addItemDecoration(
            DividerItemDecoration(
                binding.postRv.context,
                DividerItemDecoration.VERTICAL
            )
        )
        val postAdapter = PostAdapter(posts)
        binding.postRv.adapter = postAdapter
    }


    fun bla() {
       val number = 5
        bla2(number)
    }

    fun bla2(number: Int) {
        number
    }
}