package com.example.mad_project.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.example.mad_project.navigation.*
import com.example.mad_project.navigation.nav_graph.SetupNavGraph
import com.example.mad_project.widgets.BottomBar
import com.example.mad_project.widgets.HomeTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        HomeTopAppBar()
        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(RELAX_GRAPH_ROUTE) },
            text = "RELAX"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(LEARNING_GRAPH_ROUTE) },
            text = "LEARNING"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(Screen.Timer.route) },
            text = "TIMER"
        )


        Scaffold(bottomBar = { BottomBar(navController = navController)}) {

        }
    }
}