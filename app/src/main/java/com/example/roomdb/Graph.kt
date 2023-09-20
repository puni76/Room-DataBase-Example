package com.example.roomdb

import com.example.roomdb.data.room.TodoDatabase

object Graph {
    lateinit var database: TodoDatabase
        private set
    val todoRepo by lazy {
        TodoDataSource(database.todoDao())
    }
    fun provide(todoDatabase: TodoApplication) {
        database = todoDatabase
    }

}