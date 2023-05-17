package com.example.mad_project.learning

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class LearningViewModel : ViewModel() {
    private val _learningList = getLearnings().toMutableStateList()

    val learningList: List<Learning>
        get() = _learningList

    fun filterLearning(learningId: String): Learning {
        return learningList.filter { it.id == learningId}[0]
    }
}