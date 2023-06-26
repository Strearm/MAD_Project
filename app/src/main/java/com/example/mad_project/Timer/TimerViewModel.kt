package com.example.mad_project.Timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    //region Variables
    //region UIVariables
    private var _buttonState = MutableStateFlow(false)
    val buttonState = _buttonState.asStateFlow()

    private var _inputEnabled = MutableStateFlow(false)
    val inputEnabled = _inputEnabled.asStateFlow()

    private var _hours = MutableStateFlow("00")
    val hours = _hours.asStateFlow()

    private var _minutes = MutableStateFlow("00")
    val minutes = _minutes.asStateFlow()

    private var _seconds = MutableStateFlow("00")
    val seconds = _seconds.asStateFlow()
    //endregion UIVariables

    private var lastProperInput: String = "00"
    //endregion Variables

    //region FUNCTIONS

    fun disableInput(){
        _inputEnabled.value = true
    }
    fun enableInput(){
        _inputEnabled.value = false
    }
    fun toggleStart() {
        _buttonState.value = !_buttonState.value
    }
    fun toFalse() {
        _buttonState.value = false
    }
    fun updateHours(hour: String) {
        _hours.value = checkUnder99(hour)
    }
    fun updateMin(minute: String) {
        _minutes.value = checkUnder60(minute)
    }
    fun updateSec(second: String) {
        _seconds.value = checkUnder60(second)
    }
    private fun checkUnder60(value: String): String {
        return if (value.isEmpty()) {
            "00"
        } else if (value.toIntOrNull() == null) {
            lastProperInput
        } else if (value.toInt() >= 60) {
            "59"
        } else {
            lastProperInput = value
            value
        }
    }
    private fun checkUnder99(value: String): String {
        return if (value.isEmpty()) {
            "00"
        } else if (value.toIntOrNull() == null) {
            lastProperInput
        } else if (value.toInt() > 99) {
            "99"
        } else {
            lastProperInput = value
            value
        }
    }
    fun checkFinished(): Boolean {
        return _hours.value.toInt() > 0 || _minutes.value.toInt() > 0 || _seconds.value.toInt() > 0
    }
    fun resetCounter(hours: String, minutes: String, seconds: String) {
        _hours.value = hours
        _minutes.value = minutes
        _seconds.value = seconds
    }

    suspend fun countDown() {
        viewModelScope.launch(){
            var currentSec = _seconds.value.toInt()
            var currentMin = _minutes.value.toInt()
            var currentH = _hours.value.toInt()

            while (currentSec >= 0 && _buttonState.value) {
                _seconds.value = String.format("%02d", currentSec)
                _minutes.value = String.format("%02d", currentMin)
                _hours.value = String.format("%02d", currentH)
                currentSec -= 1
                delay(timeMillis = 1000L)
                if (currentMin > 0 && currentSec < 0) {
                    currentMin -= 1
                    currentSec = 59
                } else if (currentH > 0 && currentMin == 0 && currentSec < 0) {
                    currentH -= 1
                    currentMin = 59
                    currentSec = 59
                } else if (currentH <= 0 && currentMin <= 0 && currentSec <= 0) {
                    _hours.value = "00"
                    _minutes.value = "00"
                    _seconds.value = "00"
                    toFalse()
                }
            }
        }
    }
    //endregion FUNCTIONS
}