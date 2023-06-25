package com.example.mad_project.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mad_project.repository.TaskRepository

class AddTaskViewModelFactory (private val repository: TaskRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddTaskViewModel::class.java)){
            return AddTaskViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}