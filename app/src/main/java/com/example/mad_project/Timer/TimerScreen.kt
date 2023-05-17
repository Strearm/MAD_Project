package com.example.mad_project.Timer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mad_project.widgets.SimpleTopAppBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.timer

@Composable
fun TimerScreen(navController: NavController) {
    //region variable declarations
    //region time variables
    var hours by rememberSaveable { mutableStateOf("00") }
    var minutes by rememberSaveable { mutableStateOf("00") }
    var seconds by rememberSaveable { mutableStateOf("00") }
    var currentSec = seconds.toInt()
    var currentMin = minutes.toInt()
    var currentH = hours.toInt()
    //endregion time variables

    //region errors
    var secondsError by rememberSaveable{ mutableStateOf(false) }
    var minutesError by rememberSaveable{ mutableStateOf(false) }
    var hoursError by rememberSaveable{ mutableStateOf(false) }
    //endregion errors

    var startButtonState by rememberSaveable{
        mutableStateOf(false)
    }
    var textLock by rememberSaveable{
        mutableStateOf(false)
    }
    var buttonEnable by rememberSaveable{
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()
    val timerViewModel: TimerViewModel = viewModel()
    //endregion variable declarations
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }
            ) {
                Text(text = "Timer")
            }
            Column(
                modifier = Modifier.weight(weight = 9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            )
            {
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier.weight(3f),
                        value = hours,
                        onValueChange = { hours = timerViewModel.checkUnder24(it)
                                        hoursError = timerViewModel.checkInput(hours)
                                        },
                        singleLine = true,
                        readOnly = textLock,
                        label = { Text(text = "Hours") },
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
                        isError = hoursError
                    )
                    OutlinedTextField(
                        modifier = Modifier.weight(3f),
                        value = minutes,
                        onValueChange = { minutes = timerViewModel.checkUnder60(it)
                                        minutesError = timerViewModel.checkInput(minutes)
                                        },
                        singleLine = true,
                        readOnly = textLock,
                        label = { Text(text = "Minutes") },
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
                        isError = minutesError
                    )
                    OutlinedTextField(
                        modifier = Modifier.weight(3f),
                        value = seconds,
                        onValueChange = { seconds = timerViewModel.checkUnder60(it)
                                        secondsError = timerViewModel.checkInput(seconds)},
                        singleLine = true,
                        readOnly = textLock,
                        label = { Text(text = "Seconds") },
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
                        isError = secondsError
                    )
                }
                //inputFields()
                Clock(hour = hours, minute = minutes, second = seconds)
            }
            Row(modifier = Modifier.weight(1f)) {
                buttonEnable = currentH > 0 || currentMin > 0 || currentSec > 0
                Button(modifier = Modifier
                    .weight(1f)
                    .padding(15.dp),
                    enabled = buttonEnable,
                    onClick = {
                        startButtonState = !startButtonState
                        textLock = !textLock
                        coroutineScope.launch {
                            while (currentSec >= 0 && startButtonState) {
                                seconds = String.format("%02d", currentSec)
                                minutes = String.format("%02d", currentMin)
                                hours = String.format("%02d", currentH)
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
                                    hours = "00"
                                    minutes = "00"
                                    seconds = "00"
                                    startButtonState = !startButtonState
                                    textLock = !textLock
                                }
                            }
                        }
                    }
                ){
                    Text(text = if (startButtonState) "Stop" else "Start")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(modifier = Modifier
                    .weight(1f)
                    .padding(15.dp),
                    onClick = {
                        startButtonState = false
                        textLock = false
                        hours = "00"
                        minutes = "00"
                        seconds = "00"
                    }) {
                    Text(text = "Reset")
                }
            }
        }
    }
}


@Composable
fun Clock(hour: String, minute: String, second: String) {
    var hours = hour.ifEmpty { "00" }
    var minutes = minute.ifEmpty { "00" }
    var seconds = second.ifEmpty { "00" }
    Text(text = "$hours : $minutes : $seconds")
}

@Composable
fun inputFields(){
    var inputHours by rememberSaveable {
        mutableStateOf("")
    }
    var inputMinutes  by rememberSaveable {
        mutableStateOf("")
    }
    var inputSeconds by rememberSaveable {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier.padding(15.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(3f),
            value = inputHours,
            onValueChange = { inputHours = it },
            singleLine = true,
            label = { Text(text = "Hours") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End)
        )
        OutlinedTextField(
            modifier = Modifier.weight(3f),
            value = inputMinutes,
            onValueChange = { inputMinutes = it },
            singleLine = true,
            label = { Text(text = "Minutes") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End)

        )
        OutlinedTextField(
            modifier = Modifier.weight(3f),
            value = inputSeconds,
            onValueChange = { inputSeconds = it },
            singleLine = true,
            label = { Text(text = "Seconds") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End)
        )
    }
}
