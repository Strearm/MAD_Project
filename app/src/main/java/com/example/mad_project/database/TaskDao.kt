package com.example.mad_project.database

import androidx.room.*
import com.example.mad_project.tasks.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun add(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * from task")
    fun allTasks() : Flow<List<Task>>
}