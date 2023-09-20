package com.example.roomdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    val toDo:String,
    val time:String,
    val isComplete:Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id:Long =0,
)
