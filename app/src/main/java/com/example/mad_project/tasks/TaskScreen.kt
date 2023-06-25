package com.example.mad_project.tasks

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mad_project.database.TaskDataBase
import com.example.mad_project.navigation.Screen
import com.example.mad_project.repository.TaskRepository
import com.example.mad_project.widgets.BottomBar
import com.example.mad_project.widgets.SimpleTopAppBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Date

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(navController: NavHostController) {
    val db = TaskDataBase.getDatabase(LocalContext.current)
    val repository = TaskRepository(taskDao = db.taskDao())
    val factory = TaskViewModelFactory(repository = repository)
    val taskViewModel: TaskViewModel = viewModel(factory = factory)

    val taskList = taskViewModel.tasks.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SimpleTopAppBar(
                navController = navController,
                arrowBackClicked = { navController.popBackStack() }
            ) {
                Text(text = "Tasks")
            }
        },
        bottomBar = {
            BottomBar(
                navController = navController)
        }
    ) { innerPadding ->
        MainContent(
            modifier = Modifier.padding(innerPadding),
            taskList = taskList.value,
            taskViewModel = taskViewModel,
            navController = navController,
            coroutineScope = coroutineScope
        )
    }

}

@Composable
fun MainContent(modifier: Modifier,
                taskList: List<Task>,
                taskViewModel: TaskViewModel,
                navController: NavHostController,
                coroutineScope: CoroutineScope){
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(10.dp)) {
            Button(onClick = { navController.navigate(route = Screen.addTasks.route) }) {
                Text(text = "+ Add Task")
            }
        }

        TaskList(tasks = taskList,
            onTaskChecked = { task ->
                coroutineScope.launch {
                    taskViewModel.toggleChecked(task)
                }
            },
            onTaskDelete = { task ->
                coroutineScope.launch {
                    taskViewModel.deleteTask(task)
                }
            }
        )
    }
}

@Composable
fun TaskList(
    tasks: List<Task>,
    onTaskChecked: (Task) -> Unit = {},
    onTaskDelete: (Task) -> Unit = {}
) {
    LazyColumn {
        items(tasks) { task ->
            TaskItem(taskName = task.name, date = task.date, time = task.time,
                taskChecked = task.isChecked,
                onCheckedChange = { onTaskChecked(task) },
                onTaskDelete = { onTaskDelete(task) })
        }
    }
}

@Composable
fun TaskItem(
    taskName: String, date: String, time: String, taskChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTaskDelete: () -> Unit
) {
    var checked by remember {
        mutableStateOf(taskChecked)
    }
    val showDialog = remember {
        mutableStateOf(false)
    }

    //delete confirmation Dialog
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = {
                Text(text = "WARNING!", fontWeight = FontWeight.Bold)
            },
            text = {
                Text("Are you sure you want to delete:\n$taskName ?", fontSize = 20.sp)
            },
            confirmButton = {
                Button(
                    onClick = {
                        onTaskDelete()
                        showDialog.value = false
                    }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
                ) {
                    Text("Cancel")
                }
            }
        )
    }
    //Task card element
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        border = BorderStroke(2.dp, color = MaterialTheme.colors.primary)
    ) {
        Column() {
            Row(modifier = Modifier.padding(5.dp)) {
                //task name text
                Text(text = taskName, fontSize = 20.sp)
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        checked = !checked
                        onCheckedChange(it)
                    }
                )
                IconButton(onClick = { showDialog.value = true }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "deleteButton")
                }
            }
            // task date and time
            Row(modifier = Modifier.padding(5.dp)) {
                Text(text = "$date      $time", fontSize = 20.sp)
            }
        }
    }
}