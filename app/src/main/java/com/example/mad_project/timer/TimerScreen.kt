package com.example.mad_project.timer

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mad_project.widgets.BottomBar
import com.example.mad_project.widgets.SimpleTopAppBar
import kotlinx.coroutines.launch

var globSec: String = "00"
var globMin: String = "00"
var globH: String = "00"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TimerScreen(navController: NavHostController) {
    //region variable declarations
    val coroutineScope = rememberCoroutineScope()
    val timerViewModel: TimerViewModel = viewModel()
    val startButtonState by timerViewModel.buttonState.collectAsState()
    val inputEnable by timerViewModel.inputEnabled.collectAsState()

    val Sec by timerViewModel.seconds.collectAsState()
    val Min by timerViewModel.minutes.collectAsState()
    val Hour by timerViewModel.hours.collectAsState()
    //endregion variable declarations

    Scaffold(bottomBar = { BottomBar(navController = navController) }) {
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
                SimpleTopAppBar(
                    arrowBackClicked = { navController.popBackStack() },
                    navController = navController
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
                    InputFields(
                        timerViewModel = timerViewModel,
                        startButtonState = inputEnable
                    )
                    //RealTimeCountdown
                    Clock(hour = Hour, minute = Min, second = Sec)
                }
                //buttonRow
                ButtonRow(
                    timerViewModel = timerViewModel,
                    startButtonState = startButtonState,
                    onStartStopClick = {
                        timerViewModel.toggleStart()
                        coroutineScope.launch {
                            timerViewModel.countDown()
                        }
                    },
                    onResetClick = {
                        timerViewModel.toFalse()
                        timerViewModel.resetCounter(
                            hours = globH,
                            minutes = globMin,
                            seconds = globSec
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun Clock(hour: String, minute: String, second: String) {
    val hours = hour.ifEmpty { "00" }
    val minutes = minute.ifEmpty { "00" }
    val seconds = second.ifEmpty { "00" }
    Text(text = "$hours : $minutes : $seconds", fontSize = 30.sp, fontWeight = FontWeight.Bold)
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
    onStartStopClick: () -> Unit = {},
    onResetClick: () -> Unit = {}
) {
    val showPauseContinueButton = remember {
        mutableStateOf(false)
    }

    Row() {
        if (showPauseContinueButton.value && timerViewModel.checkFinished()) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 15.dp, vertical = 65.dp),
                onClick = onStartStopClick
            ) {
                Text(text = if (startButtonState) "Pause" else "Continue")
            }
        } else {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 15.dp, vertical = 65.dp),
                enabled = timerViewModel.checkFinished(),
                onClick = {
                    onStartStopClick()
                    showPauseContinueButton.value = true
                    timerViewModel.disableInput()
                }
            ) {
                Text(text = "Start")
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 15.dp, vertical = 65.dp),
            onClick = {
                onResetClick()
                showPauseContinueButton.value = false
                timerViewModel.enableInput()
            }
        ) {
            Text(text = "Reset")
        }
    }
}
