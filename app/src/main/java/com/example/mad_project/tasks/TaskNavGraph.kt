package com.example.mad_project.tasks

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mad_project.navigation.Screen
import com.example.mad_project.navigation.TASKS_GRAPH_ROUTE

fun NavGraphBuilder.taskNavGraph (navController: NavHostController){

    navigation(startDestination = Screen.Tasks.route, route = TASKS_GRAPH_ROUTE)
    {
        composable(route = Screen.Tasks.route){
            TaskScreen(navController = navController)
        }

        composable(route = Screen.addTasks.route){
            AddTaskScreen(navController = navController)
        }
    }
}