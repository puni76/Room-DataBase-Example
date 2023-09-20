package com.example.roomdb.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.TodoApplication
import com.example.roomdb.data.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase(){
    abstract fun todoDao() : TodoDao

            companion object {
                @Volatile
                private var INSTANCE : TodoDatabase? = null
                fun getDatabase(context: TodoApplication) : TodoDatabase{
                    return INSTANCE ?:synchronized(this){
                        val instance = Room.databaseBuilder(
                            context.applicationContext,
                            TodoDatabase::class.java,
                            "todo_db"
                        ).build()
                        INSTANCE = instance
                        instance
                    }
                }

            }
}