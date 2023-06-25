package com.example.mad_project.tasks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name: String,
    val date: String,
    val time: String,
    var isChecked : Boolean = false
)


fun getTasks(): List<Task>{
    return listOf(
        Task(
            name = "First Task",
            date = "12-04-2023",
            time = "12:30",
            isChecked = false
        ),
        Task(
            name = "Second Task",
            date = "16-12-2023",
            time = "12:12",
            isChecked = false
        ),
        Task(
            name = "Third Task",
            date = "01-04-2023",
            time = "12:30",
            isChecked = false
        )
    )
}