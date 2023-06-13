package com.example.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.models.Comment

class CommentAdapter(var comments: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var commentPostId: TextView = view.findViewById(R.id.comment_post_id)
        var commentId: TextView = view.findViewById(R.id.comment_id)
        var commentName: TextView = view.findViewById(R.id.comment_name)
        var commentEmail: TextView = view.findViewById(R.id.comment_email)
        var commentBody: TextView = view.findViewById(R.id.comment_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.arrangment_comment, parent, false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments [position]
        holder.commentPostId.text = comment.postId.toString()
        holder.commentId.text = comment.id.toString()
        holder.commentName.text = comment.name
        holder.commentEmail.text = comment.email
        holder.commentBody.text = comment.body
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}
