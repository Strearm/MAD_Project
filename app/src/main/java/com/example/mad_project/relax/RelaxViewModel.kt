package com.example.mad_project.relax

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class RelaxViewModel : ViewModel() {
    private val _relaxList = getRelaxTechnique().toMutableStateList()

    val relaxList: List<RelaxTechnique>
        get() = _relaxList

    fun filterRelaxTechnique(relaxId: String): RelaxTechnique {
        return relaxList.filter { it.id == relaxId }[0]
    }
}

