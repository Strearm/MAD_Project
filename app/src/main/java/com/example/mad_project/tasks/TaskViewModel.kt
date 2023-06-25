package com.example.mad_project.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mad_project.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository): ViewModel() {
    private val _tasks = MutableStateFlow(listOf<Task>())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect{ taskList ->
                    _tasks.value = taskList
            }
        }
    }

    suspend fun toggleChecked(task: Task){
        task.isChecked = !task.isChecked
        repository.update(task)
    }

    suspend fun deleteTask(task: Task){
        repository.delete(task)
    }
}