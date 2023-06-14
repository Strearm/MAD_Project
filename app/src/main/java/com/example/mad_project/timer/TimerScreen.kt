package com.example.mad_project.timer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mad_project.widgets.SimpleTopAppBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
var globSec: String = "00"
var globMin: String = "00"
var globH: String = "00"
@Composable
fun TimerScreen(navController: NavController) {
    //region variable declarations
    val coroutineScope = rememberCoroutineScope()
    val timerViewModel: TimerViewModel = viewModel()
    val startButtonState by timerViewModel.buttonState.collectAsState()

    val Sec by timerViewModel.seconds.collectAsState()
    val Min by timerViewModel.minutes.collectAsState()
    val Hour by timerViewModel.hours.collectAsState()
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
            //TopBAR
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
                //Main Content
                InputFields(timerViewModel = timerViewModel, startButtonState = startButtonState)
                //RealTimeCountdown
                Clock(hour = Hour, minute = Min, second = Sec)
            }
            Row(modifier = Modifier.weight(1f)) {
                //buttonRow
                ButtonRow(
                    timerViewModel = timerViewModel,
                    startButtonState = startButtonState,
                    coroutineScope = coroutineScope
                )
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
fun InputFields(timerViewModel: TimerViewModel, startButtonState: Boolean) {
    //region time variables
    var hours by rememberSaveable { mutableStateOf("00") }
    var minutes by rememberSaveable { mutableStateOf("00") }
    var seconds by rememberSaveable { mutableStateOf("00") }
    //endregion time variables
    Row(
        modifier = Modifier.padding(15.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(3f),
            value = hours,
            onValueChange = {
                timerViewModel.updateHours(it)
                hours = timerViewModel.hours.value
                globH = hours
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(),
            singleLine = true,
            readOnly = startButtonState,
            label = { Text(text = "Hours") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
        )
        OutlinedTextField(
            modifier = Modifier.weight(3f),
            value = minutes,
            onValueChange = {
                timerViewModel.updateMin(it)
                minutes = timerViewModel.minutes.value
                globMin = minutes
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            readOnly = startButtonState,
            label = { Text(text = "Minutes") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
        )
        OutlinedTextField(
            modifier = Modifier.weight(3f),
            value = seconds,
            onValueChange = {
                timerViewModel.updateSec(it)
                seconds = timerViewModel.seconds.value
                globSec = seconds
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            readOnly = startButtonState,
            label = { Text(text = "Seconds") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
        )
    }
}

@Composable
fun ButtonRow(
    timerViewModel: TimerViewModel,
    startButtonState: Boolean,
    coroutineScope: CoroutineScope
) {
    Row() {

        Button(modifier = Modifier
            .weight(1f)
            .padding(15.dp),
            enabled = timerViewModel.checkFinished(),
            onClick = {
                timerViewModel.toggleStart()
                coroutineScope.launch {
                    timerViewModel.countDown()
                }
            }
        ) {
            Text(text = if (startButtonState) "Pause" else "Start")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(modifier = Modifier
            .weight(1f)
            .padding(15.dp),
            onClick = {
                timerViewModel.toFalse()
                timerViewModel.resetCounter(hours = globH, minutes = globMin, seconds = globSec)
            }) {
            Text(text = "Reset")
        }
    }
}