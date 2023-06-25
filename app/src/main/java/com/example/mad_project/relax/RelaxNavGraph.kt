package com.example.mad_project.relax

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.mad_project.navigation.RELAX_GRAPH_ROUTE
import com.example.mad_project.navigation.Screen
import com.example.mad_project.navigation.relaxId

// function to build the nav graph for relax
fun NavGraphBuilder.relaxNavGraph(
    navController: NavHostController
) {
    // navigation block for relax
    navigation(
        startDestination = Screen.Relax.route,
        route = RELAX_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Relax.route
        ) {//screen for displaying RelaxScreen
            RelaxScreen(navController = navController)
        }

        composable(
            route = Screen.Detail_Relax.route,
            arguments = listOf(navArgument(name = relaxId) { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong(relaxId)
            val videoUrl = getRelaxTechnique().find { it.id == id.toString() }?.videoUrl
            if (videoUrl != null) {
                // screen for displaying DetailRelaxScreen
                DetailRelaxScreen(
                    navController = navController,
                    id = id,
                    videoUrl = videoUrl,
                    viewModel = RelaxViewModel()
                )
            } else {
                println("Oops, this relaxing technique was not found, sorry!")
            }
        }
    }
}

