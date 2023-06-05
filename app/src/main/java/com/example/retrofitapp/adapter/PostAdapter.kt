package com.example.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.models.Post

class PostAdapter(var posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var postUserId: TextView = view.findViewById(R.id.post_user_id)
        var postId: TextView = view.findViewById(R.id.post_id)
        var postText: TextView = view.findViewById(R.id.post_text)
        var postBody: TextView = view.findViewById(R.id.post_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.arrangment_post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts [position]
        holder.postUserId.text = post.userId.toString()
        holder.postId.text = post.id.toString()
        holder.postText.text = post.text
        holder.postBody.text = post.body
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}
