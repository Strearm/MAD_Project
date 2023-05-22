package com.example.mad_project.Timer

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class TimerViewModel :ViewModel(){
    //region UIVariables
    private var _buttonState = false
    val buttonState:Boolean
        get() = _buttonState

    private var _locked = false
    val locked:Boolean
        get() = _locked

    private var _hours = "00"
    val hours: String
        get() = _hours

    private var _minutes = "00"
    val minutes:String
        get() = _minutes

    private var _seconds = "00"
    val seconds:String
        get() = _seconds
    //endregion UIVariables

    private var lastProperInput: String = "00"

    val hMinSecFlow = flow<Int> {
        val startValue = _seconds.toInt()
        var current = startValue
        while (current > 0) {
            delay(1000L)
            current -= 1
            emit(current)
        }
    }

    //region FUNCTIONS
    fun toggleStart(){ _buttonState = !_buttonState }
    fun toFalse(){ _buttonState = false }
    fun updateHours(hour: String){
        _hours = checkUnder24(hour)
    }
    fun updateMin(minute: String){
        _minutes = checkUnder60(minute)
    }
    fun updateSec(second: String){
        _seconds = checkUnder60(second)
    }
    fun checkUnder60(value:String): String{
        return if(value.isEmpty()){
            "00"
        }else if(value.toIntOrNull() == null){
            lastProperInput
        } else if(value.toInt() >= 60){
            "59"
        } else{
            lastProperInput = value
            value
        }
    }
    fun checkUnder24(value:String): String{
        return if(value.isEmpty()){
            "00"
        }else if(value.toIntOrNull() == null){
            lastProperInput
        } else if(value.toInt() >= 24){
            "24"
        } else{
            lastProperInput = value
            value
        }
    }
    suspend fun countDownSimple(value: String){
        var currentValue = value.toInt()
        while(currentValue >0){
            currentValue -= 1
            delay(timeMillis = 1000L)
        }
    }
    suspend fun countDown(){
        var currentSec = _seconds.toInt()
        var currentMin = _minutes.toInt()
        var currentH = _hours.toInt()

        while (currentSec >= 0 && buttonState) {
            _seconds = String.format("%02d", currentSec)
            _minutes = String.format("%02d", currentMin)
            _hours = String.format("%02d", currentH)
            currentSec -= 1
            delay(timeMillis = 1000L)
            if(currentMin > 0 && currentSec < 0){
                currentMin -= 1
                currentSec = 59
            }else if (currentH > 0 && currentMin == 0 && currentSec < 0){
                currentH -= 1
                currentMin = 59
                currentSec = 59
            }else if(currentH <= 0 && currentMin <= 0 && currentSec <= 0){
                _hours = "00"
                _minutes = "00"
                _seconds = "00"
                toggleStart()
            }
        }
    }
    //endregion FUNCTIONS
}