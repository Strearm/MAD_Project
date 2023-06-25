package com.example.mad_project.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mad_project.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AddTaskViewModel(private val repository: TaskRepository): ViewModel(){
    //private val _tasks = MutableStateFlow(listOf<Task>())

//    init {
//        viewModelScope.launch {
//            repository.getAll().collect{ taskList ->
//                    _tasks.value = taskList
//            }
//        }
//    }
    suspend fun addTask(task: Task){
        repository.add(task)
    }

    fun validateInputNotEmpty(input: String): Boolean{
        return input.isEmpty()
    }
}