package com.example.mad_project.repository

import com.example.mad_project.database.TaskDao
import com.example.mad_project.tasks.Task

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun add(task: Task) = taskDao.add(task)

    suspend fun delete(task: Task) = taskDao.delete(task)

    suspend fun update(task: Task) = taskDao.update(task)

    fun getAll() = taskDao.allTasks()

}