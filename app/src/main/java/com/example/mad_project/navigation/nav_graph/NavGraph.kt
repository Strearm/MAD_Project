package com.example.mad_project.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mad_project.learning.*
import com.example.mad_project.navigation.HOME_GRAPH_ROUTE
import com.example.mad_project.navigation.ROOT_GRAPH_ROUTE
import com.example.mad_project.relax.relaxNavGraph
import com.example.mad_project.tasks.taskNavGraph

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    val learningViewModel: LearningViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ){
        homeNavGraph(navController = navController)
        relaxNavGraph(navController = navController)
        taskNavGraph(navController = navController)
        learningNavGraph(navController = navController, learningViewModel = learningViewModel)

    }
}