package com.example.mad_project.Timer

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel

class TimerViewModel :ViewModel(){

    private val _buttonState = false
    val buttonState:Boolean
        get() = _buttonState

    fun toggleStart(){
        _buttonState != _buttonState
    }

    fun checkInput(value: String):Boolean{
        return value.toIntOrNull() == null
    }
    fun checkUnder60(value:String): String{

        return if(value.toIntOrNull() == null){
            "00"
        } else if(value.toInt() >= 60){
            "59"
        } else{
            value
        }
    }
    fun checkUnder24(value:String): String{
        return if(value.toIntOrNull()== null){
            "00"
        } else if(value.toInt() > 24 ){
            "24"
        } else{
            value
        }
    }
}