package com.example.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.models.ToDo

class ToDoAdapter(var todos: List<ToDo>) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var toDoUserId: TextView = view.findViewById(R.id.todo_user_id)
        var toDoId: TextView = view.findViewById(R.id.todo_id)
        var toDoTitle: TextView = view.findViewById(R.id.todo_title)
        var toDoCompleted: TextView = view.findViewById(R.id.todo_completed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.arrangment_todo, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todo = todos [position]
        holder.toDoUserId.text = todo.userId.toString()
        holder.toDoId.text = todo.id.toString()
        holder.toDoTitle.text = todo.title
        holder.toDoCompleted.text = todo.completed.toString()
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}
