package com.example.mad_project.navigation.nav_graph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.mad_project.navigation.LEARNING_GRAPH_ROUTE
import com.example.mad_project.navigation.Screen
import com.example.mad_project.navigation.learningId
import com.example.mad_project.screens.DetailLearningScreen

fun NavGraphBuilder.learningNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Learning.route,
        route = LEARNING_GRAPH_ROUTE
    ){
        composable(
            route = Screen.Detail_Learning.route,
            arguments = listOf(navArgument(name = learningId) {type = NavType.LongType})
        ) {backStackEntry ->
            DetailLearningScreen(
                navController = navController,
                id = backStackEntry.arguments?.getLong(learningId))
        }
    }
}