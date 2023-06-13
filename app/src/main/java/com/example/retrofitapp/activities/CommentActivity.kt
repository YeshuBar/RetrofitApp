package com.example.retrofitapp.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.retrofitapp.R
import com.example.retrofitapp.adapter.CommentAdapter
import com.example.retrofitapp.databinding.ActivityCommentBinding
import com.example.retrofitapp.viewmodels.CommentViewModel

class CommentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fetchCommentRemote.setOnClickListener {

            val commentViewModel: CommentViewModel by viewModels()

            commentViewModel.commentLiveData.observe(this) {
                binding.commentRv.addItemDecoration(
                    DividerItemDecoration(
                        binding.commentRv.context,
                        DividerItemDecoration.VERTICAL
                    )
                )

                val commentAdapter = CommentAdapter(it)
                binding.commentRv.adapter = commentAdapter
            }

            commentViewModel.getComments()
        }


        binding.fetchCommentLocal.setOnClickListener {

            val commentViewModel: CommentViewModel by viewModels()

            commentViewModel.commentLiveData.observe(this) {
                if (it.isEmpty()) {
                    AlertDialog.Builder(this)
                        .setTitle(getString(R.string.please_fetch_first))
                        .setMessage(getString(R.string.please_fetch_first))
                        .setPositiveButton(android.R.string.ok) { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
            } else {
                    binding.commentRv.addItemDecoration(
                        DividerItemDecoration(
                            binding.commentRv.context,
                            DividerItemDecoration.VERTICAL
                        )
                    )

                    val commentAdapter = CommentAdapter(it)
                    binding.commentRv.adapter = commentAdapter
                }

            }
            commentViewModel.getCommentsFromDB()
        }
    }
}
