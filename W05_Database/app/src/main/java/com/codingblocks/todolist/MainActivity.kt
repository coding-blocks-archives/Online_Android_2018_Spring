package com.codingblocks.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.codingblocks.todolist.db.MyDbHelper
import com.codingblocks.todolist.db.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val todos = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdapter = ArrayAdapter<Todo>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                todos
        )
        val db = MyDbHelper(this).writableDatabase

        fun refreshTodoList () {
            val todoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }
        lvTodos.adapter = todoAdapter
        refreshTodoList()

        btnAddTodo.setOnClickListener {
            val newTodo = Todo(
                    etNewTodo.text.toString(),
                    false
            )
            TodoTable.insertTodo(db, newTodo)
            refreshTodoList()
        }
    }
}
