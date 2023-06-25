package com.example.mad_project.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mad_project.database.TaskDataBase
import com.example.mad_project.repository.TaskRepository
import com.example.mad_project.widgets.SimpleTopAppBar
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

@Composable
fun AddTaskScreen(navController: NavHostController) {
    val db = TaskDataBase.getDatabase(LocalContext.current)
    val repository = TaskRepository(taskDao = db.taskDao())
    val factory = AddTaskViewModelFactory(repository = repository)
    val addTaskViewModel: AddTaskViewModel = viewModel(factory = factory)

    val coroutineScope = rememberCoroutineScope()

    var taskName by rememberSaveable() { mutableStateOf("") }
    var taskDate by rememberSaveable() { mutableStateOf("") }
    var taskTime by rememberSaveable() { mutableStateOf("") }
    var nameEmpty by rememberSaveable() { mutableStateOf(true) }

    Column {
        SimpleTopAppBar(
            arrowBackClicked = { navController.popBackStack() },
            navController = navController
        ) {
            Text(text = "Add Task")
        }
        OutlinedTextField(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            value = taskName,
            onValueChange = {
                taskName = it
                nameEmpty = addTaskViewModel.validateInputNotEmpty(taskName)
            },
            label = { Text(text = "Name of Task") })
        Row {
            Box(modifier = Modifier.weight(1f)) {
                taskDate = dateField()
            }
            Box(modifier = Modifier.weight(1f)) {
                taskTime = timeField()
            }
        }
        Row(modifier = Modifier.padding(10.dp)) {
            //add task to db
            Button(enabled = !nameEmpty, onClick = {
                coroutineScope.launch {
                    addTaskViewModel.addTask(
                        Task(
                            name = taskName,
                            date = taskDate,
                            time = taskTime
                        )
                    )
                }
                navController.popBackStack()
            }) {
                Text(text = "Add")
            }
        }
    }
}

@Composable
fun dateField(): String {
    val dateDialogState = rememberMaterialDialogState()
    var dateTextState by remember {
        mutableStateOf("")
    }

    ReadonlyTextField(
        modifier = Modifier.padding(15.dp),
        value = dateTextState,
        onValueChange = { dateTextState = it },
        onClick = { dateDialogState.show() }
    ) {
        Text(text = "Date (optional)")
    }
    MaterialDialog(
        dialogState = dateDialogState,
        onCloseRequest = { dateDialogState.hide() },
        buttons = {
            positiveButton("Confirm")
            negativeButton("Cancel")
        }
    )
    {
        datepicker { date ->
            val formattedDate = date.format(
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
            )
            dateTextState = formattedDate
        }
    }
    return dateTextState
}

@Composable
fun timeField(): String {
    val timeDialogState = rememberMaterialDialogState()
    var timeTextState by remember {
        mutableStateOf("")
    }

    ReadonlyTextField(
        modifier = Modifier.padding(15.dp),
        value = timeTextState,
        onValueChange = { timeTextState = it },
        onClick = { timeDialogState.show() }
    ) {
        Text(text = "Time (optional)")
    }
    MaterialDialog(
        dialogState = timeDialogState,
        onCloseRequest = { timeDialogState.hide() },
        buttons = {
            positiveButton("Confirm")
            negativeButton("Cancel")
        }
    )
    {
        timepicker { time ->
            val formattedTime = time.format(
                DateTimeFormatter.ofPattern("hh:mma")
            )
            timeTextState = formattedTime
        }
    }
    return timeTextState
}

@Composable
fun ReadonlyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: @Composable () -> Unit
) {
    Box {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = label
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .alpha(0f)
                .clickable(onClick = onClick),
        )
    }
}