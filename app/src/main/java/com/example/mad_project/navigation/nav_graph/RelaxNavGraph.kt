package com.example.mad_project.navigation.nav_graph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.mad_project.navigation.RELAX_GRAPH_ROUTE
import com.example.mad_project.navigation.Screen
import com.example.mad_project.navigation.relaxId
import com.example.mad_project.screens.DetailRelaxScreen
import com.example.mad_project.screens.RelaxScreen

fun NavGraphBuilder.relaxNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Relax.route,
        route = RELAX_GRAPH_ROUTE
    ){
        composable(
            route = Screen.Relax.route
        ) {
            RelaxScreen(navController = navController)
        }
        
        composable(
            route = Screen.Detail_Relax.route,
            arguments = listOf(navArgument(name = relaxId) {type = NavType.LongType})
        ) { DetailRelaxScreen(
                navController = navController)
        }
    }
}