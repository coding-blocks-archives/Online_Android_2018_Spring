package com.codingblocks.kotlintodolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.codingblocks.kotlintodolist.adapters.TodoAdapter
import com.codingblocks.kotlintodolist.models.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val todos: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("First Task", false))

        rvTodos.layoutManager = LinearLayoutManager(this)
        val todoAdapter: TodoAdapter = TodoAdapter(todos)
        rvTodos.adapter = todoAdapter

        btnAdd.setOnClickListener {
            val newTodo = etNewTodo.text.toString()
            todos.add(Todo(newTodo, false))
            todoAdapter.notifyDataSetChanged()
        }
    }
}
