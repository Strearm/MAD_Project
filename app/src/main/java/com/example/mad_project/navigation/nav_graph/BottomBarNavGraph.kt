package com.example.mad_project.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import com.example.mad_project.learning.learningNavGraph
import com.example.mad_project.navigation.HOME_GRAPH_ROUTE
import com.example.mad_project.relax.relaxNavGraph

@Composable
fun BottomBarNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = HOME_GRAPH_ROUTE){

        homeNavGraph(navController = navController)
        relaxNavGraph(navController = navController)
    }
}