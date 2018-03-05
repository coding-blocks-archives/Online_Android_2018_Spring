package com.codingblocks.kotlintodolist.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codingblocks.kotlintodolist.R
import com.codingblocks.kotlintodolist.models.Todo



class TodoAdapter (
        val todos: ArrayList<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoViewHolder {
        val li = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_todo, parent, false)
        return TodoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder?, position: Int) {
        holder?.tvTodoTask?.text = todos[position].task
    }

    class TodoViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val tvTodoTask: TextView = item.findViewById(R.id.tvTodoTask)
    }
}