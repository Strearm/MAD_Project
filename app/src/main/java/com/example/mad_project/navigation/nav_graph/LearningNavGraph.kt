package com.example.mad_project.navigation.nav_graph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.mad_project.navigation.*
import com.example.mad_project.screens.*

fun NavGraphBuilder.learningNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Learning.route,
        route = LEARNING_GRAPH_ROUTE
    ){
        composable(
            route = Screen.Learning.route
        ) {
            LearningScreen(navController = navController)
        }

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