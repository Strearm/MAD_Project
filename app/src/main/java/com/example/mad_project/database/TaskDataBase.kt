package com.example.mad_project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mad_project.tasks.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDataBase: RoomDatabase() {
    abstract fun taskDao() : TaskDao

    companion object{
        @Volatile
        private var Instance : TaskDataBase? = null
        fun getDatabase (context: Context):TaskDataBase {
            return Instance?: synchronized(this){
                Room.databaseBuilder(context, TaskDataBase::class.java,"task_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}