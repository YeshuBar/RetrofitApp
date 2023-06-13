package com.example.retrofitapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.repositories.RepoFactory

// Make a list of the following:
// 1. Code that can be removed
// 2. Code that can be consolidated
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        RepoFactory.context = application

        binding.commentManager?.setOnClickListener {
            val intent = Intent(this, CommentActivity::class.java)
            startActivity(intent)
        }

        binding.postManager?.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }
    }
}

