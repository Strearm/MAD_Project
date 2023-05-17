package com.example.mad_project.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mad_project.Timer.TimerScreen
import com.example.mad_project.navigation.HOME_GRAPH_ROUTE
import com.example.mad_project.navigation.Screen
import com.example.mad_project.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        
        composable(
            route = Screen.Timer.route
        ){
            TimerScreen(navController = navController)
        }
    }
}